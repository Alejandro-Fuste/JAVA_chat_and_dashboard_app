// Logout, employee name and form selectors
const logoutButtonEl = document.querySelector("#businessLogoutEl");
// const nameEl = document.querySelector('#employeeName');
// const pitchFormEl = document.querySelector("#pitchForm");
const pitchButtonEl = document.querySelector("#submitPitchButton");
const sendCommentBusiness = document.querySelector("#sendButtonBiz");

// Logout event listener
// logoutButtonEl.addEventListener("click", logout);

// Create Pitch event listener
pitchButtonEl.addEventListener("click", createPitchBusiness);

// Send comment event listener
sendCommentBusiness.addEventListener("click", sendBusinessComment);

// logout event listener
logoutButtonEl.addEventListener("click", logout);
