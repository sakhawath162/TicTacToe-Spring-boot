let moves = []
let turn = true

const makeTable = (size) => {
    moves = []
    let row;
    let table = `<table>
    <tbody>`;
    for (let i = 0; i < size; i++) {
        table += '<tr>'
        row = []
        for (let j = 0; j < size; j++) {
            table += `<td onclick="playGame(${i},${j})" id="row_${i}${j}"></td>`
            row.push(null)
        }
        table += '</tr>'
        moves.push(row)
    }
    table += `</tbody>
    </table>`;

    document.getElementById("table_div").innerHTML = table

}


const playGame = (i, j) => {
    if (moves[i][j] == null) {
        if (turn) {
            moves[i][j] = "CROSS"
        } else {
            moves[i][j] = "CIRCLE"
        }
        turn = !turn

        document.getElementById(`row_${i}${j}`).innerHTML = moves[i][j]
        console.log(moves)

    }

}


const submitToServer = () => {
    const grid_size = document.getElementById("grid_size").value
    if (grid_size) {
        let data = {}
        if (grid_size !== 3) {
            data.size = grid_size
        }
        data.moves = moves
        fetch('http://localhost:8081/api/ticTacToe/gameWinner', {
            method: 'POST', 
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
            .then(response => response.json())
            .then(data => {
                document.getElementById("message").innerHTML=data.message
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }


}

document.getElementById("grid_size_btn").addEventListener("click", () => {
    const grid_size = document.getElementById("grid_size").value
    if (grid_size >= 3) {
        makeTable(grid_size)
    }
});