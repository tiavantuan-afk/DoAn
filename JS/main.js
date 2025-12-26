let currentSlide = 0;
let slides, dots, totalSlides;

// Initialize when DOM is ready
document.addEventListener('DOMContentLoaded', function () {
    slides = document.querySelectorAll('.slide');
    dots = document.querySelectorAll('.dot');
    totalSlides = slides.length;

    // Auto-change slide every 5 seconds
    setInterval(() => {
        currentSlide = (currentSlide + 1) % totalSlides;
        updateSlide();
    }, 5000);
});

// Manual slide change
function changeSlide(index) {
    currentSlide = index;
    updateSlide();
}

// Update slide display
function updateSlide() {
    if (!slides || !dots) return;

    // Remove active class from all slides and dots
    slides.forEach(slide => slide.classList.remove('active'));
    dots.forEach(dot => dot.classList.remove('active'));

    // Add active class to current slide and dot
    if (slides[currentSlide]) slides[currentSlide].classList.add('active');
    if (dots[currentSlide]) dots[currentSlide].classList.add('active');
}
