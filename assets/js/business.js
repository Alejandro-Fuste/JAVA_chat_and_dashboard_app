// Logout, employee name and form selectors
const logoutButtonEl = document.querySelector("#businessLogoutEl");
const nameEl = document.querySelector("#headerFullName");
// const pitchFormEl = document.querySelector("#pitchForm");
const pitchButtonEl = document.querySelector("#submitPitchButton");
const sendCommentBusiness = document.querySelector("#sendButtonBiz");

// Add name to element
nameEl.textContent = getName();

// get pitches

// get comments

// Logout event listener
logoutButtonEl.addEventListener("click", logout);

// Create Pitch event listener
pitchButtonEl.addEventListener("click", createPitchBusiness);

// Send comment event listener
sendCommentBusiness.addEventListener("click", sendBusinessComment);

// logout event listener
logoutButtonEl.addEventListener("click", logout);
