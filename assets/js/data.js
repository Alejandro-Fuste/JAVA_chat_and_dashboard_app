const sendSharkComment = (e) => {
<<<<<<< HEAD
    e.preventDefault();
    let reciepient = document.querySelector("#reciepientfromShark").value.trim();
    let date = document.querySelector("#commentDateShark").value.trim();
    let comment = document.querySelector("#commentShark").value.trim();
  
    let data = {
      reciepient,
      date,
      comment,
    };
  
    console.table(data);
  };
  
  const sendBusinessComment = (e) => {
    e.preventDefault();
  
    let reciepient = document.querySelector("#reciepientfromBiz").value.trim();
    let date = document.querySelector("#commentDateBiz").value.trim();
    let comment = document.querySelector("#commentBusiness").value.trim();
  
    let data = {
      reciepient,
      date,
      comment,
    };
  
    console.table(data);
  };
  
  const createPitchBusiness = (e) => {
    e.preventDefault();
  
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
  
    console.table(data);
  };
=======
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

  // get url depending the role the user selects
  let url = "https://58e44f55-bd3b-4e4f-9f73-6396bd1d959b.mock.pstmn.io/";

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

  // get url depending the role the user selects
  let url = "https://58e44f55-bd3b-4e4f-9f73-6396bd1d959b.mock.pstmn.io/";

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
      successEl.style.display = "block";
    })
    .catch((err) => {
      errorEl.style.display = "block";
    });
};
>>>>>>> 757b3ba27dfad7161e6410be2a838f285a3f5811
