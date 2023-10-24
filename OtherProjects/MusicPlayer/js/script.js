const wrapper = document.querySelector(".wrapper"),
  musicImg = wrapper.querySelector(".img-area img"),
  musicName = wrapper.querySelector(".song-details .name"),
  musicArtist = wrapper.querySelector(".song-details .artist"),
  mainAudio = wrapper.querySelector("#main-audio"),
  playPauseButton = wrapper.querySelector(".play-pause"),
  previousButton = wrapper.querySelector("#previous"),
  nextButton = wrapper.querySelector("#next"),
  progressArea = wrapper.querySelector(".progress-area"),
  progressBar = wrapper.querySelector(".progress-bar"),
  musicList = wrapper.querySelector(".music-list"),
  showMoreButton = wrapper.querySelector("#more-music"),
  hideButton = wrapper.querySelector("#close");

// random nhạc hiện lên mỗi khi refresh trang
let musicIndex = Math.floor((Math.random() * allMusic.length) + 1);

// gọi function load nhạc mỗi khi load lại trang
window.addEventListener("load", () => {
  loadMusic(musicIndex);
  playingNow();
})

// load nhạc
function loadMusic (indexNumber) {
  musicName.innerText = allMusic[indexNumber - 1].name;
  musicArtist.innerText = allMusic[indexNumber - 1].artist;
  musicImg.src = `photos/${allMusic[indexNumber - 1].img}.jpg`;
  mainAudio.src = `music/${allMusic[indexNumber - 1].src}.mp3`;
}

// phát nhạc
function playMusic () {
  wrapper.classList.add("paused");
  playPauseButton.querySelector("i").innerText = "pause";
  mainAudio.play();
}

// tạm dừng
function pauseMusic () {
  wrapper.classList.remove("paused");
  playPauseButton.querySelector("i").innerText = "play_arrow";
  mainAudio.pause();
}

// phát bài tiếp theo
function nextMusic () {
  musicIndex++;
  if (musicIndex > allMusic.length) {
    musicIndex = 1;
  } else {
    musicIndex;
  };
  loadMusic(musicIndex);
  playMusic();
  playingNow();
}

// phát bài trước đó
function previousMusic () {
  musicIndex--;
  if (musicIndex < 1) {
    musicIndex = allMusic.length;
  } else {
    musicIndex;
  }
  loadMusic(musicIndex);
  playMusic();
  playingNow();
}

// phát nhạc hoặc tạm dừng dựa vào nút
playPauseButton.addEventListener("click", () => {
  const isMusicPaused = wrapper.classList.contains("paused");
  isMusicPaused ? pauseMusic() : playMusic();
  playingNow();
});

// nút phát bài tiếp theo
nextButton.addEventListener("click", () => {
  nextMusic();
});

// nút phát bài trước đó
previousButton.addEventListener("click", () => {
  previousMusic();
});

// hiện thời gian hiện tại và tổng thời gian của bài hát
let musicCurrentTime = wrapper.querySelector(".current");
let musicDurationTime = wrapper.querySelector(".duration");
mainAudio.addEventListener("timeupdate", (e) => { // chạy thanh tiến trình dựa vào thời gian hiện tại của bài hát
  const currentTime = e.target.currentTime;
  const duration = e.target.duration;
  let progressWidth = (currentTime / duration) * 100;
  progressBar.style.width = `${progressWidth}%`;

  mainAudio.addEventListener("loadeddata", () => {
    let audioDuration = mainAudio.duration;
    let totalMin = Math.floor(audioDuration / 60);
    let totalSec = Math.floor(audioDuration % 60);
    if (totalSec < 10) {
      totalSec = `0${totalSec}`;
    }
    musicDurationTime.innerText = `${totalMin}:${totalSec}`;
  });
  let currentMin = Math.floor(currentTime / 60);
  let currentSec = Math.floor(currentTime % 60);
  if (currentSec < 10) {
    currentSec = `0${currentSec}`;
  }
  musicCurrentTime.innerText = `${currentMin}:${currentSec}`;
});

// cập nhật thời gian hiện tại khi thanh tiến trình thay đổi
progressArea.addEventListener("click", (e) => {
  let progressWidthval = progressArea.clientWidth;
  let clickOffSetX = e.offsetX;
  let songDuration = mainAudio.duration;

  mainAudio.currentTime = (clickOffSetX / progressWidthval) * songDuration;
});

// tạo các nút lặp lại, trộn và phát theo thứ tự
const repeatButton = wrapper.querySelector("#repeat-playlist");
repeatButton.addEventListener("click", () => {
  let getText = repeatButton.innerText;
  switch (getText) { // đổi nút khi nhấn vào
    case "repeat":
      repeatButton.innerText = "repeat_one";
      repeatButton.setAttribute("title", "Song looped");
      break;
    case "repeat_one":
      repeatButton.innerText = "shuffle";
      repeatButton.setAttribute("title", "Playback shuffled");
      break;
    case "shuffle":
      repeatButton.innerText = "repeat";
      repeatButton.setAttribute("title", "Playlist looped");
      break;
  }
});

// code để các nút trên hoạt động
mainAudio.addEventListener("ended", () => {
  let getText = repeatButton.innerText;
  switch (getText) {
    case "repeat":
      nextMusic();
      break;
    case "repeat_one":
      mainAudio.currentTime = 0; // đưa thời gian về lại ban đầu
      loadMusic(musicIndex);
      playMusic();
      break;
    case "shuffle": // random 1 bài nhạc trong list sau khi bài nhạc hiện tại kết thúc
      let randomIndex = Math.floor((Math.random() * allMusic.length) + 1);
      do {
        randomIndex = Math.floor((Math.random() * allMusic.length) + 1);
      } while (musicIndex == randomIndex); // vòng lặp để chống phát lại 1 bài giống nhau
      musicIndex = randomIndex;
      loadMusic(musicIndex);
      playMusic();
      playingNow();
      break;
  }
});

// nút hiện danh sách nhạc
showMoreButton.addEventListener("click", () => {
  musicList.classList.toggle("show");
});

// nút ẩn danh sách nhạc
hideButton.addEventListener("click", () => {
  showMoreButton.click();
});

// lấy thông tin của bài nhạc
const ulTag = wrapper.querySelector("ul");
for (let i = 0; i < allMusic.length; i++) {
  let liTag = `<li li-index="${i + 1}">
                  <div class="row">
                    <span>${allMusic[i].name}</span>
                    <p>${allMusic[i].artist}</p>
                  </div>
                  <audio class="${allMusic[i].src}" src="music/${allMusic[i].src}.mp3"></audio>
                  <span id="${allMusic[i].src}" class="audio-duration">1:51</span>
                </li>`;
  ulTag.insertAdjacentHTML("beforeend", liTag); // thêm thông tin nhạc vào thẻ ul

  // hiện tổng thời gian trong danh sách
  let liAudioDuration = ulTag.querySelector(`#${allMusic[i].src}`);
  let liAudioTag = ulTag.querySelector(`.${allMusic[i].src}`);

  liAudioTag.addEventListener("loadeddata", () => {
    let audioDuration = liAudioTag.duration;
    let totalMin = Math.floor(audioDuration / 60);
    let totalSec = Math.floor(audioDuration % 60);
    if (totalSec < 10) {
      totalSec = `0${totalSec}`;
    }
    liAudioDuration.innerText = `${totalMin}:${totalSec}`;
    liAudioDuration.setAttribute("t-duration", `${totalMin}:${totalSec}`);
  });
}

// hiện chữ Playing khi bài nhạc đó đang được phát
const allLiTags = ulTag.querySelectorAll("li");
function playingNow () {
  for (let j = 0; j < allLiTags.length; j++) {
    let audioTag = allLiTags[j].querySelector(".audio-duration");

    if (allLiTags[j].classList.contains("playing")) {
      allLiTags[j].classList.remove("playing");
      let adDuration = audioTag.getAttribute("t-duration");
      audioTag.innerText = adDuration;
    }

    if (allLiTags[j].getAttribute("li-index") == musicIndex) {
      allLiTags[j].classList.add("playing");
      audioTag.innerText = "Playing";
    }
    allLiTags[j].setAttribute("onclick", "clicked(this)")
  }
}

// phát nhạc khi click vào bài nhạc đó
function clicked (element) {
  let getLiIndex = element.getAttribute("li-index");
  musicIndex = getLiIndex;
  loadMusic(musicIndex);
  playMusic();
  playingNow();
}
