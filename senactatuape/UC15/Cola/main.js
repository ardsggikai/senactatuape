window.addEventListener('scroll', onScroll)

onScroll()
function onScroll() {
  showNavOnScroll()
  showBackToTopButtonOnScroll()
  activateMenuAtCurrentSection()
}

function activateMenuAtCurrentSection() {

  const targetLine = scrollY + innerHeight / 2
  
  //verificar se seção passou da linha
  //quais dados vou precisar?
  const sectionTop = home.offsetTop

  const sectionHeight = home.offsetHeight

  //const sectionTopReachOrPassedTargetLine
}

function showNavOnScroll() {
  if (scrollY > 0) {
    navbarHeader.classList.add('scroll')
  } else {
    navbarHeader.classList.remove('scroll')
  }
}

function showBackToTopButtonOnScroll() {
  if (scrollY > 500) {
    backToTopButton.classList.add('show')
  } else {
    backToTopButton.classList.remove('show')
  }
}

function openMenu() {
  document.body.classList.add('menu-expanded')
}

function closeMenu() {
  document.body.classList.remove('menu-expanded')
}

ScrollReveal({
  origin: 'top',
  distance: '30px',
  duration: 700,
}).reveal(`
  #home, 
  #home img, 
  #home .stats, 
  #services,
  #services header,
  #services .card,
  #about,
  #about header,
  #about .content`)
