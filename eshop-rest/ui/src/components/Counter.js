const pavadinimas = "Paspausk"

export default ({ tekstas }) => {
	console.log("Properties", tekstas)

	return (
		<>
			<span>{tekstas}</span>
			<button>{pavadinimas}</button>
		</>
	)
}
