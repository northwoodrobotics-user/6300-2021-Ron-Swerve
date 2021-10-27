package frc.robot.commands.buttons;
import frc.robot.subsystems.Intake;
public class ToggleIntake {
    private double m_percent;
    public ToggleIntake(double percent){
        super();


        m_percent = percent;
    }
    protected void initialize(){
        Intake.getInstance().RunIntake(m_percent);
    }

    
}
