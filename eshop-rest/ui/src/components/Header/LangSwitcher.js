import Select from "@material-ui/core/Select";
import MenuItem from "@material-ui/core/MenuItem";
import { useTranslation } from "react-i18next";
import React from "react";

export default () => {

    const { i18n } = useTranslation();

    const handleLangChange = (e) => {
        i18n.changeLanguage(e.target.value)
    }

    return (
        <Select
          labelId="lang-label"
          value={i18n.language}
          onChange={handleLangChange}
        >
          <MenuItem value={'lt'}>LT</MenuItem>
          <MenuItem value={'en'}>EN</MenuItem>
        </Select>
    )
}