// Logout, employee name and form selectors
const logoutButtonEl = document.querySelector("#businessLogoutEl");
// const nameEl = document.querySelector('#employeeName');
// const pitchFormEl = document.querySelector("#pitchForm");
const pitchButtonEl = document.querySelector("#submitPitchButton");

// Logout event listener
// logoutButtonEl.addEventListener("click", logout);

// Create Pitch event listener
pitchButtonEl.addEventListener("click", (e) => {
  e.preventDefault();

  console.log("pitch form submitted");

  // let pitchUrl = 'http://127.0.0.1:5000/reimbursement';
  // let data = createObject();

  // createReimbursement(pitchUrl, data);
});
