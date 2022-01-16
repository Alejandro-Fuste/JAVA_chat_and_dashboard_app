// Logout, employee name and form selectors
const logoutButtonEl = document.querySelector("#businessLogoutEl");
const nameEl = document.querySelector("#headerFullName");
const profileNameEl = document.querySelector("#fullName");
// const pitchFormEl = document.querySelector("#pitchForm");
const pitchButtonEl = document.querySelector("#submitPitchButton");
const sendCommentBusiness = document.querySelector("#sendButtonBiz");

// Add name to element
nameEl.textContent = getName();
profileNameEl.textContent = getName();

// get pitches
let pitchesUrl = `http://localhost:8080/pitches`;
fetch(pitchesUrl)
  .then((res) => res.json())
  .then((data) => createPitch(data))
  .catch((err) => console.log(err));

// get all comments
let commentsUrl = `http://localhost:8080/commentingAll`;
fetch(commentsUrl)
  .then((res) => res.json())
  .then((data) => createComment(data))
  .catch((err) => console.log(err));

// Logout event listener
logoutButtonEl.addEventListener("click", logout);

// Create Pitch event listener
pitchButtonEl.addEventListener("click", createPitchBusiness);

// Send comment event listener
sendCommentBusiness.addEventListener("click", sendBusinessComment);

// logout event listener
logoutButtonEl.addEventListener("click", logout);
