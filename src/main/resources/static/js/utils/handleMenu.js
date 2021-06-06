const tabs = document.querySelector('.tabs');
const tabContent = document.querySelector('.tab__content');
const tabsText = document.querySelectorAll('.tabs__text');
const navbarButton = document.querySelector('.navbar__button');
const layer = document.querySelector('.layer');

const handleMenu = () => {
  tabs.classList.toggle('tabs--open');
  layer.classList.toggle('layer--open');
  if (tabs.classList.contains(['tabs--open'])) {
    tabContent.classList.add('tab__content--open');
    tabsText.forEach(tabText => tabText.classList.add('tabs__text--open'));
  } else {
    tabContent.classList.remove('tab__content--open');
    tabsText.forEach(tabText => tabText.classList.remove('tabs__text--open'))
  }
}

navbarButton.addEventListener('click', handleMenu);

layer.addEventListener('click', handleMenu);