// lo({
//   businessId: 1,
//   firstName: "Bruce",
//   lastName: "Wayne",
//   businessName: "Wayne Enterprises",
//   username: "Wayne100",
//   password: "ImBatman",
//   role: "business",
// });

// const login = (data) => {
//   e.preventDefault();
//   console.log(data);
//   const errorEl = document.querySelector("#hideErrorMessage");

//   // send data retrieved from database to localStorage
//   localStorage.setItem("pseudoToken", JSON.stringify(data));

//   // redirect user base the role property in data
//   let expr = data.role;
//   switch (expr) {
//     case "business":
//       window.location.assign("/business.html");
//       break;
//     case "shark":
//       window.location.assign("/shark.html");
//       break;
//     default:
//       errorEl.setAttribute("id", "errorMessage");
//       errorEl.textContent =
//         "Opps, something went wrong...refresh and try again!";
//   }
// };

const logout = () => {
  // delete fake token from local storage
  localStorage.removeItem("pseudoToken");

  // redirect user back to home page
  window.location.href(
    "file:///Users/alejandro/Desktop/JAVA_investing_app/home.html"
  );
};

// const loginUser = async () => {
//   // error message selector
//   const errorEl = document.querySelector("#hideErrorMessage");

//   // Get username, password, and role from inputs
//   let userName = document.querySelector("#userName").value.trim();
//   let userPassword = document.querySelector("#password").value.trim();
//   let role = document.querySelector("#roleSignIn").value;

//   let arrayData = [userName, userPassword, role];

//   // create object for request body
//   let loginData = {
//     username: userName,
//     password: userPassword,
//   };

//   console.log(loginData);

//   // get url depending the role the user selects
//   // let url = "https://58e44f55-bd3b-4e4f-9f73-6396bd1d959b.mock.pstmn.io/";

//   let url = "http://localhost:8080/";

//   role === "Business" ? (url += `business/login`) : (url += `shark/login`);

//   console.log(url);

//   // use fetch to send login request to server
//   // fetch(url, {
//   //   method: "POST",
//   //   mode: "cors",
//   //   headers: {
//   //     Accept: "application/json",
//   //     "Content-Type": "application/json",
//   //   },
//   //   body: JSON.stringify(loginData),
//   // })
//   //   .then((response) => response.json())
//   //   .then((data) => {
//   //     console.log(data);
//   //     // login(data);
//   //   })
//   //   .catch((err) => {
//   //     errorEl.setAttribute("id", "errorMessage");
//   //     errorEl.textContent = err;
//   //   });

//   let response = await fetch(url, {
//     method: "POST",
//     mode: "cors",
//     headers: { "Content-Type": "application/json" },
//     body: JSON.stringify(loginData),
//   });
//   if (response.status === 200) {
//     let body = await response.json();
//     console.log(body);
//     login(body);
//   } else {
//     errorEl.setAttribute("id", "errorMessage");
//     errorEl.textContent = body;
//   }
// };

const createUser = (e) => {
  e.preventDefault();

  signupValidation();

  // error message selector
  const errorEl = document.querySelector("#hideErrorMessage");

  // Get first name, last name, business name, user name, password, and role from inputs
  let firstName = document.querySelector("#firstName").value.trim();
  let lastName = document.querySelector("#lastName").value.trim();
  let businessName = document.querySelector("#businessName").value.trim();
  let userName = document.querySelector("#userName").value.trim();
  let password = document.querySelector("#signupPassword").value.trim();
  let role = document.querySelector("#role").value.trim();

  let data = [firstName, lastName, businessName, userName, password, role];

  // let createData = {
  //   firstName,
  //   lastName,
  //   businessName,
  //   userName,
  //   password,
  //   role,
  // };

  // urls
  let url =
    "https://58e44f55-bd3b-4e4f-9f73-6396bd1d959b.mock.pstmn.io/business/create";

  // let url = "http://localhost:8080/business/create";

  // use fetch to send sign up request to server
  fetch(url, {
    method: "POST",
    mode: "cors",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => response.json())
    .then(window.location.assign("/home.html"))
    .catch((err) => {
      errorEl.setAttribute("id", "errorMessage");
      errorEl.textContent = err;
    });
};

// ----------------- SIGNUP VALIDATION-------------------

function signupValidation() {
  let firstName = document.querySelector("#firstName").value.trim();
  let lastName = document.querySelector("#lastName").value.trim();
  let businessName = document.querySelector("#businessName").value.trim();
  let userName = document.querySelector("#userName").value.trim();
  let password = document.querySelector("#signupPassword").value.trim();
  let role = document.querySelector("#role").value.trim();
  let invalidChars = [
    "0",
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9",
    "!",
    "@",
    "#",
    "$",
    "%",
    "^",
    "&",
    "*",
  ];

  let data = {};

  if (
    firstName.length == 0 ||
    lastName.length == 0 ||
    businessName.length == 0 ||
    userName.length == 0 ||
    password.length == 0 ||
    role != "Shark" ||
    role != "Business"
  ) {
    alert("Please enter all values!");
    return null;
  } else {
    data.firstName = firstName;
    data.lastName = lastName;
    data.businessName = businessName;
    data.userName = userName;
    data.password = password;
    data.role = role;
  }

  if (
    firstName.length > 20 ||
    lastName.length > 20 ||
    businessName.length > 20 ||
    userName.length > 20 ||
    password.length > 30
  ) {
    alert("Your entry is too long!");
  } else {
    data.firstName = firstName;
    data.lastName = lastName;
    data.businessName = businessName;
    data.userName = userName;
    data.password = password;
    data.role = role;
  }

  if (userName.length < 5) {
    alert("Your username is too short!");
  } else {
    data.userName = userName;
  }

  if (password.length < 8) {
    alert("Your password is too short!");
  } else {
    data.password = password;
  }

  for (char of invalidChars) {
    if (
      firstName.includes(char) ||
      lastName.includes(char) ||
      role.includes(char)
    ) {
      alert("Please enter only letters!");
      break;
    } else {
      data.firstName = firstName;
      data.lastName = lastName;
      data.role = role;
    }
  }
}
