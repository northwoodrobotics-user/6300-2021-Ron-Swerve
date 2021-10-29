package frc.robot.commands.buttons;

import frc.robot.subsystems.Climber;

public class ToggleClimb {
    private double m_percent;
    public ToggleClimb(double percent){
        super();
        m_percent = percent;
    }
    protected void initialize(){
        Climber.getInstance().RunClimber(m_percent);
    }
    
}
