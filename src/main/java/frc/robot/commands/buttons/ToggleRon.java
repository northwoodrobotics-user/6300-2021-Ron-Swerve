package frc.robot.commands.buttons;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.RonMK1;
public class ToggleRon {

private double m_percent;

public ToggleRon(double percent){
    super();
    

    m_percent = percent;
}

protected void initialize(){
    RonMK1.getInstance().FireRon(m_percent);
}
}
