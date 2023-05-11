document.addEventListener("click", myFunction);

function myFunction() {
  var nav = document.getElementById("#my-nav");
  console.log(nav);
  if (nav.classList.contains("show")) {
    nav.classList.remove("show");
  } else {
    nav.classList.add("show");
  }
}

