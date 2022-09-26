import com.example.web3.AreaShot;
import com.example.web3.AreaShotsList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ShotTest {

    private AreaShotsList areaShotsList;
    private float step;

    @Before
    public void init() {
        areaShotsList = new AreaShotsList();
        step = 0.5f;
    }

    @Test
    public void testInsideTopRight() {
        
        for (int r = 1; r <= 5; r++) {
            areaShotsList.setR(r);
            for (float x = step; x < r; x += step) {
                for (float y = step; y < r; y += step) {
                    System.out.println("Test: r = " + r + ", x = " + x + ", y = " + y);
                    AreaShot shot = createShot(x, y);
                    Assert.assertTrue(shot.isResult());
                }
            }
        }
    }

    @Test
    public void testOutside() {
        for (int r = 1; r <= 4; r++) {
            areaShotsList.setR(r);
            for (float x = -5 + step; x < 5; x += step) {
                for (float y = -5 + step; y < 5; y += step) {
                    if (x >= -r && x <= r && y <= 0 && y >= -r) continue;
                    if (x >= 0 && x <= r && y >= 0 && y <= r) continue;
                    System.out.println("Test: r = " + r + ", x = " + x + ", y = " + y);
                    AreaShot shot = createShot(x, y);
                    Assert.assertFalse(shot.isResult());
                }
            }
        }
    }

    @Test
    public void testBorders() {
        for (int r = 1; r <= 5; r++) {
            areaShotsList.setR(r);
            for (float x = -r; x <= r; x += step) {
                System.out.println("Test: r = " + r + ", x = " + x + ", y = " + 0);
                AreaShot shot = createShot(x, 0);
                Assert.assertTrue(shot.isResult());
            }
            for (float y = -r; y <= r; y += step) {
                System.out.println("Test: r = " + r + ", x = " + 0 + ", y = " + y);
                AreaShot shot = createShot(0, y);
                Assert.assertTrue(shot.isResult());
            }
        }

    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        areaShotsList.setR(-1);
    }

    private AreaShot createShot(float x, float y) {
        AreaShot areaShot = new AreaShot();
        areaShot.setY(y);
        areaShot.setX(x);
        areaShotsList.setShot(areaShot);
        areaShotsList.addShot();
        return areaShot;
    }

}

