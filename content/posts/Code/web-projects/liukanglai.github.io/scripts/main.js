// let/var: 一个变量
let myHeading = document.querySelector("h1"); // 获取h1标题
let myButton = document.querySelector("button");

myHeading.textContent = "Hello world!"; // 设置h1标题
document.querySelector("html").onclick = function () {
  alert("别戳我，我怕疼。");
};
/* document.querySelector("html").addEventListener("click", function () { // 匿名函数
    alert("别戳我，我怕疼。");
 });
*/

let myImage = document.querySelector("img");

myImage.onclick = function () {
  let mySrc = myImage.getAttribute("src");
  if (mySrc === "images/lufei.jpg") {
    myImage.setAttribute("src", "images/l.png");
  } else {
    myImage.setAttribute("src", "images/lufei.jpg");
  }
};

function setUserName() {
  let myName = prompt("请输入你的名字。");
  if (!myName || myName === null) { // 如果不输入，直接按确认，是空?(没有值); 而直接按取消，是null
    setUserName();
  } else {
    localStorage.setItem("name", myName); // localStorage API可以将数据存储在浏览器中供后续获取
    myHeading.innerHTML = "Mozilla 酷毙了，" + myName;
  }
}

if (!localStorage.getItem("name")) {
  setUserName();
} else {
  let storedName = localStorage.getItem("name");
  myHeading.textContent = "Mozilla 酷毙了，" + storedName;
}

myButton.onclick = function () {
  setUserName();
};
