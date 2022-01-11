const login = (data) => {
  const errorEl = document.querySelector("#hideErrorMessage");

  // send data retrieved from database to localStorage
  localStorage.setItem("pseudoToken", JSON.stringify(data));

  // redirect user base the role property in data
  const expr = data.companyRole;
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

const loginUser = async (e) => {
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
  // let url = "https://58e44f55-bd3b-4e4f-9f73-6396bd1d959b.mock.pstmn.io/";
  let url = "http://127.0.0.1:5000/";

  role === "Business" ? (url += `business/login`) : (url += `shark/login`);

  // use fetch to send login request to server
  const response = await fetch(url, {
    method: "POST",
    mode: "cors",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(loginData),
  });

  // send user to their page if success...display error message if not
  if (response.status === 200) {
    let content = await response.json();
    // login(content);
    console.table(content);
  } else {
    let content = await response.json();
    console.log(content);
    errorEl.setAttribute("id", "errorMessage");
    errorEl.textContent = content.message;
  }
};
