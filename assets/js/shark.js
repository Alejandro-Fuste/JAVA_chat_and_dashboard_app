// Logout, employee name and form selectors
const sharkLogoutButton = document.querySelector("#sharkLogoutEl");
const nameEl = document.querySelector("#headerFullName");
const profileNameEl = document.querySelector("#fullName");
const sendCommentShark = document.querySelector("#sendButtonShark");
const pitchModalButton = document.querySelector("#pitchesDiv");
const sendPitchOffer = document.querySelector("#submitPitchButton");

// Add name to banner and profile
nameEl.textContent = getName();
profileNameEl.textContent = getName();

// get pitches
let pitchesSharkUrl = `http://localhost:8080/pitches`;
// fetch(pitchesUrl).then(res => res.json()).then(data => addPitches(data)).catch(err => console.log(err));
fetch(pitchesSharkUrl)
  .then((res) => res.json())
  .then((data) => console.log(data))
  .catch((err) => console.log(err));

// get all comments
let commentsSharkUrl = `http://localhost:8080/commentingAll`;
// fetch(commentsUrl).then(res => res.json()).then(data => addPitches(data)).catch(err => console.log(err));
fetch(commentsSharkUrl)
  .then((res) => res.json())
  .then((data) => console.table(data))
  .catch((err) => console.log(err));

// Logout event listener
sharkLogoutButton.addEventListener("click", logout);

// send comment event listener
sendCommentShark.addEventListener("click", sendSharkComment);

// shark offer event listener
sendPitchOffer.addEventListener("click", acceptPitchShark);

pitchModalButton.addEventListener("click", pitchIdShark);

// sendPitchOffer.addEventListener("click", function (e) {
//   console.log(e.target);
// });
