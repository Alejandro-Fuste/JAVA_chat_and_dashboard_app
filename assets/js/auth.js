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
  let url;

  role === "Business"
    ? (url = `http://127.0.0.1:5000/business/login`)
    : (url = `http://127.0.0.1:5000/shark/login`);

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
    login(content);
  } else {
    let content = await response.json();
    console.log(content.message);
    errorEl.setAttribute("id", "errorMessage");
    errorEl.textContent = content.message;
  }

  console.table(url);
};
