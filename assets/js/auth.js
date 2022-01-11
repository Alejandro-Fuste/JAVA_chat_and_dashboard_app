const loginUser = (e) => {
  e.preventDefault();

  let userName = document.querySelector("#userName").value.trim();
  let userPassword = document.querySelector("#password").value.trim();

  let role = document.querySelector("#roleSignIn").value;

  let url;

  role === "Business"
    ? (url = `http://127.0.0.1:5000/business/login`)
    : (url = `http://127.0.0.1:5000/shark/login`);

  let loginData = {
    userName,
    userPassword,
  };

  console.table(url);
};
