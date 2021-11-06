package frc.robot.commands.buttons;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.RonMK1;
public class ToggleRon extends InstantCommand{

private double m_percent;

public ToggleRon(double percent){
    super();
    addRequirements(RonMK1.getInstance());
    

    m_percent = percent;
}

public void initialize(){
    RonMK1.getInstance().FireRon(m_percent);
}
}
