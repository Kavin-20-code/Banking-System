function showResult(data) {

    const result =
        document.getElementById("result");

    if (typeof data === "object") {

        result.innerText =
            JSON.stringify(data, null, 2);

    } else {

        result.innerText = data;
    }
}


// Create account
function createAccount() {

    const accountNumber =
        document.getElementById("accountNumber").value;

    const accountHolder =
        document.getElementById("accountHolder").value;

    const initialBalance =
        document.getElementById("initialBalance").value;

    fetch(
        `/api/bank/account?accountNumber=${encodeURIComponent(accountNumber)}&accountHolder=${encodeURIComponent(accountHolder)}&initialBalance=${initialBalance}`,
        {
            method: "POST"
        }
    )
    .then(response => response.json())
    .then(data => {

        showResult(data);

    })
    .catch(error => {

        showResult("Error creating account.");

        console.error(error);
    });
}


// Deposit
function deposit() {

    const accountNumber =
        document.getElementById("operationAccount").value;

    const amount =
        document.getElementById("amount").value;

    fetch(
        `/api/bank/deposit?accountNumber=${encodeURIComponent(accountNumber)}&amount=${amount}`,
        {
            method: "POST"
        }
    )
    .then(response => {

        if (!response.ok) {

            return response.text()
                .then(text => {
                    throw new Error(text);
                });
        }

        return response.json();
    })
    .then(data => {

        showResult(data);

    })
    .catch(error => {

        showResult(error.message);
    });
}


// Withdraw
function withdraw() {

    const accountNumber =
        document.getElementById("operationAccount").value;

    const amount =
        document.getElementById("amount").value;

    fetch(
        `/api/bank/withdraw?accountNumber=${encodeURIComponent(accountNumber)}&amount=${amount}`,
        {
            method: "POST"
        }
    )
    .then(response => {

        if (!response.ok) {

            return response.text()
                .then(text => {
                    throw new Error(text);
                });
        }

        return response.json();
    })
    .then(data => {

        showResult(data);

    })
    .catch(error => {

        showResult(error.message);
    });
}


// Check balance
function checkBalance() {

    const accountNumber =
        document.getElementById("operationAccount").value;

    fetch(
        `/api/bank/balance?accountNumber=${encodeURIComponent(accountNumber)}`
    )
    .then(response => {

        if (!response.ok) {

            return response.text()
                .then(text => {
                    throw new Error(text);
                });
        }

        return response.json();
    })
    .then(data => {

        showResult(
            "Current Balance: ₹" + data
        );

    })
    .catch(error => {

        showResult(error.message);
    });
}


// Transaction history
function getTransactions() {

    const accountNumber =
        document.getElementById("operationAccount").value;

    fetch(
        `/api/bank/transactions?accountNumber=${encodeURIComponent(accountNumber)}`
    )
    .then(response => {

        if (!response.ok) {

            return response.text()
                .then(text => {
                    throw new Error(text);
                });
        }

        return response.json();
    })
    .then(data => {

        showResult(data);

    })
    .catch(error => {

        showResult(error.message);
    });
}