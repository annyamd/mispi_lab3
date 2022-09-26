package com.example.web3;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("yValidator")
public class YFieldValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            float y = Float.parseFloat(o + "");
            if (y > -5 && y < 3) return;
            throw new ValidatorException(new FacesMessage("nope!"));
        } catch (NumberFormatException e){
            throw new ValidatorException(new FacesMessage("y is not a number."));
        }
    }
}
