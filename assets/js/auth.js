const login = (data) => {
  const errorEl = document.querySelector("#hideErrorMessage");

  // send data retrieved from database to localStorage
  localStorage.setItem("pseudoToken", JSON.stringify(data));

  // redirect user base the role property in data
  const expr = data.role;
  switch (expr) {
    case "business":
      window.location.assign("/business.html");
      break;
    case "business":
      window.location.assign("/shark.html");
      break;
    default:
      errorEl.setAttribute("id", "errorMessage");
      errorEl.textContent =
        "Opps, something went wrong...refresh and try again!";
  }
};

const logout = () => {
  // delete fake token from local storage
  localStorage.removeItem("pseudoToken");

  // redirect user back to home page
  window.location.assign("/home.html");
};

// const validateInputs = (data) => {
//   let userName = document.querySelector("#userName").value.trim();

//   if (data.userName != '' || data.userName.length >=5){
//     userName.classList.add("is-valid");
//   } else {
//     userName.classList.add("is-valid");
//   }
// };

const loginUser = (e) => {
  e.preventDefault();

  // error message selector
  const errorEl = document.querySelector("#hideErrorMessage");

  // Get username, password, and role from inputs
  let userName = document.querySelector("#userName").value.trim();
  let userPassword = document.querySelector("#password").value.trim();
  let role = document.querySelector("#roleSignIn").value;

  // create object for request body
  let loginData = {
    userName,
    userPassword,
  };

  // get url depending the role the user selects
  let url = "https://58e44f55-bd3b-4e4f-9f73-6396bd1d959b.mock.pstmn.io/";

  // let url = "http://localhost:8080/";

  role === "Business" ? (url += `business/login`) : (url += `shark/login`);

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
    .then((data) => login(data))
    .catch((err) => {
      errorEl.setAttribute("id", "errorMessage");
      errorEl.textContent = err;
    });
};

const createUser = (e) => {
  e.preventDefault();

  // error message selector
  const errorEl = document.querySelector("#hideErrorMessage");

  // Get first name, last name, business name, user name, password, and role from inputs
  let firstName = document.querySelector("#firstName").value.trim();
  let lastName = document.querySelector("#lastName").value.trim();
  let businessName = document.querySelector("#businessName").value.trim();
  let userName = document.querySelector("#userName").value.trim();
  let password = document.querySelector("#signupPassword").value.trim();
  let role = document.querySelector("#role").value.trim();

  let data = {
    firstName,
    lastName,
    businessName,
    userName,
    password,
    role,
  };

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
