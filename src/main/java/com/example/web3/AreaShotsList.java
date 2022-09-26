package com.example.web3;

import com.example.web3.db.AreaShotDAO;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
@ManagedBean
public class AreaShotsList implements Serializable {
    private static final int R_DEFAULT = 5;

    private List<AreaShot> shots;
    private final AreaShotDAO shotsDAO;
    private AreaShot shot;
    private float r;

    public AreaShotsList(){
        shotsDAO = new AreaShotDAO();
        shot = new AreaShot();
        setR(R_DEFAULT);
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        if (r > 5 || r < 1) throw new NullPointerException();
        this.r = r;
    }

    public String addShot(){
        shot.setR(r);
//        System.out.println("rrrrrrrrrr >>>> " + r);
//        System.out.println("aaaaaaaaaa>>>>> " + shot.getR());

        shot.setResult(ShotChecker.isHit(shot));
        shotsDAO.addAreaShot(shot);
        shot = new AreaShot();
        return null;
    }

    public void changeParamR(AjaxBehaviorEvent event) {
//        System.out.println("kkkkkkkkkkkkkkkkkk >>>> " + Float.parseFloat((String) event.getComponent().getAttributes().get("value")));
        setR(Float.parseFloat((String) event.getComponent().getAttributes().get("value")));
    }

    public AreaShotDAO getShotsDAO() {
        return shotsDAO;
    }

    public AreaShot getShot() {
        return shot;
    }

    public void setShot(AreaShot shot) {
        this.shot = shot;
    }

    public boolean isListEmpty(){
        return shotsDAO.findAllAreaShots().isEmpty();
    }

    public List<AreaShot> getShots() {
        shots = shotsDAO.findAllAreaShots();
        return shots;
    }

    public void setShots(List<AreaShot> shots) {
        this.shots = shots;
    }
}
