// login selector
const formEl = document.querySelector("#submitButton");

function login(data) {
  //   e.preventDefault();
  console.log(data);
  const errorEl = document.querySelector("#hideErrorMessage");

  // send data retrieved from database to localStorage
  localStorage.setItem("pseudoToken", JSON.stringify(data));

  // redirect user base the role property in data
  let expr = data.role;
  switch (expr) {
    case "business":
      location.href = "business.html";
      break;
    case "shark":
      location.href = "shark.html";
      break;
    default:
      errorEl.setAttribute("id", "errorMessage");
      errorEl.textContent =
        "Opps, something went wrong...refresh and try again!";
  }
}

async function loginUser2() {
  console.log("five");
  // error message selector
  const errorEl = document.querySelector("#hideErrorMessage");

  console.log("6");

  // Get username, password, and role from inputs
  let userName = document.querySelector("#userName").value.trim();
  let userPassword = document.querySelector("#password").value.trim();
  let role = document.querySelector("#roleSignIn").value;

  let arrayData = [userName, userPassword, role];

  // create object for request body
  let loginData = {
    username: userName,
    password: userPassword,
  };

  console.log(loginData);

  //   get url depending the role the user selects
  //   let url = "https://58e44f55-bd3b-4e4f-9f73-6396bd1d959b.mock.pstmn.io/";

  let url = "http://localhost:8080/";

  role === "Business" ? (url += `business/login`) : (url += `shark/login`);

  console.log(url);

  // use fetch to send login request to server
  fetch(url, {
    method: "POST",
    mode: "cors",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(loginData),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      login(data);
    })
    .catch((err) => {
      errorEl.setAttribute("id", "errorMessage");
      errorEl.textContent = err;
    });

  //     let response = await fetch(url, {
  //       method: "POST",
  //       mode: "cors",
  //       headers: { "Content-Type": "application/json" },
  //       body: JSON.stringify(loginData),
  //     });

  //     if(response.)

  //   console.log("8");
}

// async function loginUser2() {
//   console.log("five");
//   const errorEl = document.querySelector("#hideErrorMessage");

//   console.log("6");

//   let userName = document.querySelector("#userName").value.trim();
//   let userPassword = document.querySelector("#password").value.trim();

//   let loginData = {
//     username: userName,
//     password: userPassword,
//   };

//   let url = "http://localhost:8080/business/login";

//   // role === "Business" ? (url += `business/login`) : (url += `shark/login`);

//   const response = await fetch(url, {
//     method: "POST",
//     mode: "cors",
//     body: JSON.stringify(loginData),
//     headers: {
//       "Content-type": "application/json; charset=UTF-8",
//     },
//   });
//   console.log(response);
// }

//   console.log("9");

// login event listener
// formEl.addEventListener("click", function (event) {
//   event.preventDefault();
//   loginUser();
// });

// formEl.addEventListener("click", function (event) {
//   event.preventDefault();
//   loginUser2(event);
// });
