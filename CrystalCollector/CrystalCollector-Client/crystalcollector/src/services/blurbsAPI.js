const url = `${process.env.REACT_APP_URL}`;


// FIND ALL BLURBS
export async function findAllBlurbs() {
    const response = await fetch(`${url}/blurbs/list`);
    if (response.status === 200) {
        return response.json();
    } else { 
        return Promise.reject("An unexpected error occurred.")
    }
}

// FIND BLURB BY ID
export async function findBlurbById(blurbsId) {
    const response = await fetch(`${url}/blurbs/detail/${blurbsId}`);
    if (response.status === 200) {
        return response.json();
    } else if (response.status === 404) {
        return Promise.reject(`Blurb id: ${blurbsId} was not found.`);
    } else {
        return Promise.reject("An unexpected error occurred.")
    }
}

// ADD AND UPDATE BLURB
export async function addOrUpdateBlurbs(blurbs) {
    const jwtToken = localStorage.getItem("jwt_token");
    if (!jwtToken) {
        return Promise.reject("Unauthorized.");
    }

    const init = {
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorization: "Bearer " + jwtToken,
        },
        body: JSON.stringify(blurbs),
    };

    if (blurbs.blurbsId > 0) {
        init.method = "PUT";
        const response = await fetch(`${url}/blurbs/update/${blurbs.blurbsId}`, init);
        if (response.status === 400) {
          const result = await response.json();
          return { errors: result.messages };
        } else if (response.status === 404) {
          return Promise.reject(
            `Blurb Id: ${blurbs.blurbsId} was not found.`
          );
        } else if (response.status !== 204) {
          return Promise.reject("An unexpected error occurred.");
        }
      } else {
        init.method = "POST";
        const response = await fetch(`${url}/blurbs/add`, init);
        if (response.status === 201) {
          return response.json();
        } else if (response.status === 400) {
          const result = await response.json();
          return { errors: result.messages };
        } else {
          return Promise.reject("An unexpected error occurred.");
        }
    }
}

//DELETE BLURB BY ID

export async function deleteBlurbById(blurbsId) {
    const jwtToken = localStorage.getItem("jwt_token");
    if (!jwtToken) {
      return Promise.reject("Unauthorized.");
    }
      
    const init = {
      method: "DELETE",
      headers: {
        "Authorization": "Bearer " + jwtToken
      },
    };
  
    const response = await fetch(`${url}/blurbs/delete/${blurbsId}`, init);
    if (response.status === 404) {
      return Promise.reject(`Blurb Id: ${blurbsId} was not found.`);
    } else if (response.status !== 204) {
      return Promise.reject("An unexpected error occurred.");
    }
}
