var choi = false
var score
var action
var timeremaining
var correctAnswer
document.getElementById("startreset").onclick = function () {
  if (choi == true) {
    location.reload()
  }
  else {
    choi = true
    score = 0
    document.getElementById("scorevalue").innerHTML = score
    show("timeremaining")
    timeremaining = 60
    document.getElementById("timeremainingvalue").innerHTML = timeremaining
    hide("gameOver")
    document.getElementById("startreset").innerHTML = "Thoát" // Đổi bắt đầu thành thoát
    startCountdown()
    generateQA()
  }
}
for (i = 1; i < 5; i++) {
  document.getElementById("box" + i).onclick = function () {
    if (choi == true) {
      if (this.innerHTML == correctAnswer) {
        score++
        document.getElementById("scorevalue").innerHTML = score
        hide("wrong")
        show("correct")
        setTimeout(function () {
          hide("correct")
        }, 1000)
        generateQA()
      } else {
        score--
        document.getElementById("scorevalue").innerHTML = score
        hide("correct")
        show("wrong")
        setTimeout(function () {
          hide("wrong")
        }, 1000)
        generateQA()
      }
    }
  }
}
function startCountdown () {
  action = setInterval(function () {
    timeremaining -= 1
    document.getElementById("timeremainingvalue").innerHTML = timeremaining
    if (timeremaining == 0) {
      show("gameOver")
      document.getElementById("gameOver").innerHTML = "<p>Kết thúc!</p><p>Điểm của bạn là " + score + ".</p>"
      hide("timeremaining")
      hide("correct")
      hide("wrong")
      choi = false
      document.getElementById("startreset").innerHTML = "Bắt đầu"
    }
  }, 1000)
}
function hide (Id) {
  document.getElementById(Id).style.display = "none"
}
function show (Id) {
  document.getElementById(Id).style.display = "block"
}
function getRandomOperator () {
  let operators = ["+", "-", "*"];
  let ran = Math.floor(Math.random() * operators.length);
  return operators[ran];
}
function getRandomNumber (min, max) {
  return Math.floor(Math.random() * (max - min)) + min;
}
function generateQA () {
  var x = getRandomNumber(-100, 100)
  var y = getRandomNumber(-100, 100)
  var op = getRandomOperator()
  if (op == "+") {
    correctAnswer = x + y
  } else if (op == "-") {
    correctAnswer = x - y
  } else if (op == "*") {
    correctAnswer = x * y
  }
  document.getElementById("question").innerHTML = x + ' ' + op + ' ' + y
  var correctPosition = 1 + Math.round(3 * Math.random());
  document.getElementById("box" + correctPosition).innerHTML = correctAnswer
  var answers = [correctAnswer];
  for (i = 1; i < 5; i++) {
    if (i != correctPosition) {
      var wrongAnswer;
      do {
        wrongAnswer = getRandomNumber(correctAnswer - 50, correctAnswer + 50)
      } while (answers.indexOf(wrongAnswer) > -1)
      document.getElementById("box" + i).innerHTML = wrongAnswer
      answers.push(wrongAnswer)
    }
  }
}

