function calcular() {
    var resp = document.querySelector("#resp")
    var veloc = document.getElementById("tvel")

    var vel = Number(veloc.value)

    resp.innerHTML = `Sua Velocidade Atual é de: 
    <strong> ${vel} km/h </strong>`

    if(vel > 50) {
        resp.innerHTML += `<p> Você será <strong> MULTADO 
        </strong> por excesso de velocidade... </p>`
    }
    resp.innerHTML += `<p> Dirija sempre com o cinto de segurança! </p>`
}