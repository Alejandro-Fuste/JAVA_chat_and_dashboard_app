// Logout, employee name and form selectors
const sharkLogoutButton = document.querySelector("#sharkLogoutEl");
// const nameEl = document.querySelector('#employeeName');
const sendCommentShark = document.querySelector("#sendButtonShark");
const sendPitchOffer = document.querySelector("#submitPitchButton");

// get pitches

// get comments

// Logout event listener
sharkLogoutButton.addEventListener("click", logout);

// send comment event listener
sendCommentShark.addEventListener("click", sendSharkComment);

// shark offer event listener
sendPitchOffer.addEventListener("click", acceptPitchShark);
