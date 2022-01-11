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
};

const createPitchBusiness = (e) => {
  e.preventDefault();
};
