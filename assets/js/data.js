// function for sending a comment from the shark end
const sendSharkComment = (e) => {
  e.preventDefault();

  let successEl = document.querySelector("#commentSent");
  let errorEl = document.querySelector("#commentError");

  let reciepient = document.querySelector("#reciepientfromShark").value.trim();
  let date = document.querySelector("#commentDateShark").value.trim();
  let comment = document.querySelector("#commentShark").value.trim();
  let sharkId = JSON.parse(localStorage.getItem("pseudoToken"));
  console.log(bizId.businessId);

  let data = {
    reciepient,
    date,
    comment,
    sharkId: sharkId.businessId,
  };

  // get url depending the role the user selects
  let url =
    "https://58e44f55-bd3b-4e4f-9f73-6396bd1d959b.mock.pstmn.io/commenting/create";

  // let url = "http://localhost:8080/commenting/create";

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
    .then((data) => {
      successEl.style.display = "block";
    })
    .catch((err) => {
      errorEl.style.display = "block";
    });
};

// function for sending a comment from the business end
const sendBusinessComment = (e) => {
  e.preventDefault();

  let errorEl = document.querySelector("#commentError");
  let successEl = document.querySelector("#commentSent");

  let reciepient = document.querySelector("#reciepientfromBiz").value.trim();
  let date = document.querySelector("#commentDateBiz").value.trim();
  let comment = document.querySelector("#commentBusiness").value.trim();
  let bizId = JSON.parse(localStorage.getItem("pseudoToken"));

  let data = {
    reciepient,
    date,
    comment,
    businessId: bizId.businessId,
  };

  // url
  let url =
    "https://58e44f55-bd3b-4e4f-9f73-6396bd1d959b.mock.pstmn.io/commenting/create";
  // let url = "http://localhost:8080/commenting/create";

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
    .then((data) => {
      successEl.style.display = "block";
    })
    .catch((err) => {
      errorEl.style.display = "block";
    });
};

// function for creating pitch
const createPitchBusiness = (e) => {
  e.preventDefault();

  let errorEl = document.querySelector("#commentError");
  let successEl = document.querySelector("#pitchCreated");

  let date = document.querySelector("#validationCustom01").value.trim();
  let amount = document.querySelector("#validationCustom02").value.trim();
  let percent = document.querySelector("#validationCustom03").value.trim();
  let pitchText = document.querySelector("#validationTextarea").value.trim();

  let data = {
    date,
    amount,
    percent,
    pitchText,
  };

  // need route from App class
  let url = "https://58e44f55-bd3b-4e4f-9f73-6396bd1d959b.mock.pstmn.io/";
  //   let url = "http://localhost:8080/;

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
    .then((data) => {
      successEl.style.display = "block";
    })
    .catch((err) => {
      errorEl.style.display = "block";
    });
};

// function for accepting pitch (shark)
const acceptPitchShark = (e) => {
  e.preventDefault();

  // get id, amount, percentage
  let amount = document.querySelector("#validationCustom02").value.trim();
  let percent = document.querySelector("#validationCustom03").value.trim();

  let data = {
    amount,
    percent,
  };

  console.table(data);

  // get urls

  // fetch with patch method, success then, failure catch
};

// function for accepting pitch (business)
const acceptPitchBusiness = (e) => {
  e.preventDefault();
  alert("pitch accepted clicked");

  // get id, amount, percentage

  // get urls

  // fetch with patch method, success then, failure catch
};

// dynamic pitches
const createPitch = (data) => {
  console.log(data);
};
// dynamic comments

const createComment = (data) => {
  console.log(data);
};
