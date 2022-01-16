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
// fetch(pitchesUrl).then(res => res.json()).then(data => addPitches(data)).catch(err => console.log(err));
fetch(pitchesUrl)
  .then((res) => res.json())
  .then((data) => console.log(data))
  .catch((err) => console.log(err));

// get all comments
let commentsUrl = `http://localhost:8080/commentingAll`;
// fetch(commentsUrl).then(res => res.json()).then(data => addPitches(data)).catch(err => console.log(err));
fetch(commentsUrl)
  .then((res) => res.json())
  .then((data) => console.table(data))
  .catch((err) => console.log(err));

// Logout event listener
logoutButtonEl.addEventListener("click", logout);

// Create Pitch event listener
pitchButtonEl.addEventListener("click", createPitchBusiness);

// Send comment event listener
sendCommentBusiness.addEventListener("click", sendBusinessComment);

// logout event listener
logoutButtonEl.addEventListener("click", logout);
