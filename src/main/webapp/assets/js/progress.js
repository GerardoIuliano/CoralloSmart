//Select the progress bar by its class
const progress = document.querySelector('.barlife');

// Set the progress bar's value based off the top input
const numerator = (e) => {
    progress.value = e.target.value;
}

// Set the progress bars max value based off the bottom input
const denominator = (e) => {
    progress.max = e.target.value;

}
