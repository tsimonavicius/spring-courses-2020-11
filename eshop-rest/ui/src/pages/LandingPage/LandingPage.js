import { useTranslation } from "react-i18next";
import {Button} from "@material-ui/core";

export default () => {

	const { t, i18n } = useTranslation();

	const changeLang = (key) => {
		i18n.changeLanguage(key)
	}

	return (
		<>
			<Button onClick={() => changeLang('en')} >Anglu kalba</Button>
			<Button onClick={() => changeLang('lt')} >Lietuviu kalba</Button>
			<h1>{t('hello')}</h1>
		</>
	)
}
