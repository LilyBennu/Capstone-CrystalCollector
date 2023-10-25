const url = `${process.env.REACT_APP_API_URL}`;


// VIEW ALL CRYSTALS
export async function viewAllCrystals() {
    const response = await fetch(`${url}/list`, {
      headers: {Authorization: `Bearer ${localStorage.getItem("jwt_token")}`}
    });
    if (response.status === 200) {
        return response.json();
    } else { 
        return Promise.reject("An unexpected error occurred.")
    }
}

// FIND CRYSTAL BY ID
export async function findCrystalById(crystalId) {
    const response = await fetch(`${url}/detail/${crystalId}`, {
      headers: {Authorization: `Bearer ${localStorage.getItem("jwt_token")}`}
    });
    if (response.status === 200) {
        return response.json();
    } else if (response.status === 404) {
        return Promise.reject(`Crystal id: ${crystalId} was not found.`);
    } else {
        return Promise.reject("An unexpected error occurred.")
    }
}

// ADD AND UPDATE CRYSTAL
export async function addOrUpdateCrystal(crystal) {
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
        body: JSON.stringify(crystal),
    };

    if (crystal.crystalId > 0) {
        init.method = "PUT";
        const response = await fetch(`${url}/update/${crystal.crystalId}`, init);
        if (response.status === 400) {
          const result = await response.json();
          return { errors: result.messages };
        } else if (response.status === 404) {
          return Promise.reject(
            `Crystal Id: ${crystal.crystalId} was not found.`
          );
        } else if (response.status !== 202) {
          return Promise.reject("An unexpected error occurred.");
        }
      } else {
        init.method = "POST";
        const response = await fetch(`${url}/add`, init);
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

//DELETE CRYSTAL BY ID

export async function removeCrystalById(crystalId) {
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
  
    const response = await fetch(`${url}/remove/${crystalId}`, init);
    if (response.status === 404) {
      return Promise.reject(`Crystal Id: ${crystalId} was not found.`);
    } else if (response.status !== 204) {
      return Promise.reject("An unexpected error occurred.");
    }
}
