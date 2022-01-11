const sendSharkComment = (e) => {
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
};
