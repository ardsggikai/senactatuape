/**
 *  Validar Campos Obrigatorios 
 */

function validar() {
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value

	if (nome === "") {
		alert("Preencha o Campo Nome")
		frmContato.nome.focus()
		return false
	}

	if (fone === "") {
		alert("Preencha o Campo Telefone")
		frmContato.fone.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}