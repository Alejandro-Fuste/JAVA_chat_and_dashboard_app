// function for getting name from local storage
const getName = () => {
  let tokenData = getToken();
  return `${tokenData["firstName"]} ${tokenData["lastName"]}`;
};

const getBusinessId = () => {
  let tokenData = getToken();
  return tokenData.businessId;
};

const getSharkId = () => {
  let tokenData = getToken();
  return tokenData.sharkId;
};

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

  commentValidation();

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

  // urls
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

const pitchIdShark = (e) => {
  localStorage.setItem("pitchId", e.target.dataset.pitchid);
};

// function for accepting pitch (shark)
const acceptPitchShark = (e) => {
  e.preventDefault();

  // get id, amount, percentage
  let id = parseInt(localStorage.getItem("pitchId"));
  let amount = document.querySelector("#validationCustom02").value.trim();
  let percent = document.querySelector("#validationCustom03").value.trim();

  let data = {
    pitchId: id,
    amount,
    percent,
  };

  console.table(data);

  // get urls
  let url = "https://58e44f55-bd3b-4e4f-9f73-6396bd1d959b.mock.pstmn.io/pitch";
  //   let url = "http://localhost:8080//pitch;

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

// dynamically rendered pitches
const createPitch = (data) => {
  console.table(data);

  // div that holds all pitches
  const commentsDivEl = document.querySelector("#pitchesDiv");

  data.forEach((c) => {
    // div that holds pitch
    let createDivTag = document.createElement("div");
    createDivTag.setAttribute("id", "pitchDiv");

    // added img for business logo
    let createImgTag = document.createElement("img");
    createImgTag.setAttribute("id", "bizPic");
    createImgTag.setAttribute("src", "./assets/images/defaultLogo.png");
    createImgTag.setAttribute("alt", "business");

    // div that holds namePercentAmountDiv & textDiv
    let createBizInfoDivTag = document.createElement("div");
    createBizInfoDivTag.setAttribute("id", "bizInfoDiv");

    // div that holds business name, percent, pitchAmount, accepted, button
    let createNamePercentAmountDivTag = document.createElement("div");
    createNamePercentAmountDivTag.setAttribute("id", "namePercentAmountDiv");

    // p tags for bizName, percent, pitchAmount, pitchAmount, pitchButtonShark
    let createbizNameP = document.createElement("p");
    createbizNameP.setAttribute("id", "bizName");
    createbizNameP.textContent = c.businessName;

    let createPercentP = document.createElement("p");
    createPercentP.setAttribute("id", "percent");
    let decimal = c.percentage;
    createPercentP.textContent = decimal.toFixed(2);

    let createPitchAmountP = document.createElement("p");
    createPitchAmountP.setAttribute("id", "pitchAmount");
    createPitchAmountP.textContent = c.amount
      .toString()
      .replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");

    let createPitchAcceptedP = document.createElement("p");
    createPitchAcceptedP.setAttribute("id", "pitchAccepted");

    if (c.status === "Accepted") {
      createPitchAcceptedP.style.display = "block";
    }

    let createButton = document.createElement("button");
    createButton.setAttribute("id", "pitchButtonShark");
    createButton.setAttribute("type", "button");
    createButton.setAttribute("id", "pitchButtonShark");
    createButton.setAttribute("class", "btn btn-primary");
    createButton.setAttribute("data-bs-toggle", "modal");
    createButton.setAttribute("data-bs-target", "pitchModal");
    createButton.setAttribute("data-pitchId", c.pitchId);
    createButton.setAttribute("data-businessId", c.businessId);
    createButton.textContent = "+";

    //div that holds pitchText
    let createPitchDivTag = document.createElement("div");
    createPitchDivTag.setAttribute("id", "textDiv");

    let createPitchTextP = document.createElement("p");
    createPitchTextP.setAttribute("id", "pitchText");
    createPitchTextP.textContent = c.pitch;

    createPitchDivTag.appendChild(createPitchTextP);
    createNamePercentAmountDivTag.append(
      createbizNameP,
      createPercentP,
      createPitchAmountP,
      createPitchAcceptedP,
      createButton
    );
    createBizInfoDivTag.append(
      createNamePercentAmountDivTag,
      createPitchDivTag
    );
    createDivTag.append(createImgTag, createBizInfoDivTag);
    commentsDivEl.appendChild(createDivTag);
  });
};

// dynamic comments
const createComment = (data) => {
  // div that holds all comments
  const commentsDivEl = document.querySelector("#commentsDiv");

  data.forEach((c) => {
    // div that holds date and comment
    let createDivTag = document.createElement("div");
    createDivTag.setAttribute("id", "commentDiv");

    let createDateP = document.createElement("p");
    createDateP.setAttribute("id", "dateP");
    createDateP.textContent = c.createDate;

    let createCommentP = document.createElement("p");
    createCommentP.setAttribute("id", "comment");
    createCommentP.textContent = c.commenting;

    createDivTag.append(createDateP, createCommentP);
    commentsDivEl.appendChild(createDivTag);
  });
};

// -------------------SHARK MAKE COMMENT VALIDATION---------------

function commentValidation() {
  let dropdown = document.querySelector("#reciepientfromShark");
  let commentSection = document.querySelector("#commentShark");
  let data = {};

  if (dropdown == null) {
    alert("Please choose one of the available options.");
  } else {
    data.dropdown = dropdown;
  }

  if (commentSection.length == 0) {
    alert("Please enter a comment.");
  } else {
    data.commentSection = commentSection;
  }
}

// -------------------Business MAKE COMMENT VALIDATION---------------
// commentValidation();
function commentValidation() {
  let dropdown = document.querySelector("#reciepientfromBiz");
  let commentSection = document.querySelector("#commentBusiness");
  let data = {};

  if (dropdown == null) {
    alert("Please choose one of the available options.");
  } else {
    data.dropdown = dropdown;
  }
  if (commentSection.length == 0) {
    alert("Please enter a comment.");
  } else {
    data.commentSection = commentSection;
  }
}
