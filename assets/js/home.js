const formEl = document.querySelector("#loginForm");

let userName = document.querySelector("#userName");
let userPassword = document.querySelector("#password");

formEl.addEventListener("submit", loginUser);

// userName.addEventListener("change", function () {
//   let userNameVal = userName.value.trim();
//   console.log(userNameVal);
//   if (userNameVal === "" || userNameVal.length < 4) {
//     userName.classList.add("is-invalid");
//   } else {
//     userName.classList.add("is-valid");
//   }
// });

// userPassword.addEventListener("change", function () {
//   let passwordVal = userPassword.value.trim();
//   if (passwordVal === "" || passwordVal.length < 4) {
//     passwordVal.classList.add("is-invalid");
//   } else {
//     passwordVal.classList.add("is-valid");
//   }
// });
