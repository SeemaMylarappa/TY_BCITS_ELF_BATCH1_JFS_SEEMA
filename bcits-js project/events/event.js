function showAlert() {
    alert("Hi welcome to Cinema hall!!!")
}
var element = document.createElement('h1')
function showElement() {

    element.textContent = "element is now created"
    document.body.appendChild(element)
}

// function displayElement() {
//     var dispElement = document.getElementById("disp")
//     dispElement.style.display='block'
// }

// function hideElement() {
//     var hideElement=document.getElementById("disp")
//     hideElement.style.display='none'

// }
function displayElement() {
    var dispElement = document.getElementById('disp')
    var myBtn = document.getElementById('myBtn');
    if (displayElement.style.display === '' ||
        displayElement.style.display === 'none') {
        displayElement.style.display = 'block'
        myBtn.textContent = 'Click here to hide h1 Element'
    } else {
        displayElement.style.display = 'none'
        myBtn.textContent = 'Click here to show h1 Element'
    }
}

function color() {
    var changeclr = document.getElementById('cgcolor')
    changeclr.style.background = 'orange';
    changeclr.style.fontSize = '30px'
}

function changeColor() {
    var changeclor = document.getElementById('cgcolor')
    changeclor.style.background = 'blue';
    changeclor.style.fontSize = '20px'
}
function showData() {
    console.log('working!!')
}
function showDetail() {
    console.log('done!!')
}
function getInputValue() {
    var inpElement = document.getElementById('inp')
    console.log(inpElement.value)
    var showElement = document.getElementById('show')
    showElement.textContent = inpElement.value
}
