function openCity(evt, cityName) {
  var i, tabcontent, tabbutton;
  
  tabcontent = document.getElementsByClassName("tab__content");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tabbutton = document.getElementsByClassName("tabs__button");
  for (i = 0; i < tabbutton.length; i++) {
    tabbutton[i].className = tabbutton[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
} 