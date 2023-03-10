// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveWithController;
import frc.robot.commands.Forward;
import frc.robot.commands.StraightLine_AButton;
import frc.robot.commands.Turn90;
import frc.robot.commands.Turn90_BButton;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();
  //Should these two commands below have m_ prefix? 
  private final StraightLine_AButton m_straightLine = new StraightLine_AButton(m_romiDrivetrain,24);
  private final Turn90_BButton m_turnRight = new Turn90_BButton(m_romiDrivetrain);
  private DriveWithController m_controldrive = new DriveWithController(m_romiDrivetrain);
  private final Forward m_forward = new Forward(m_romiDrivetrain,5);
  //end of new stuff / testing

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_romiDrivetrain);

  //Xboxcontroller object for DriveWithController file
  public static final XboxController m_xboxController = new XboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //Kevin showed this example not understood yet
     m_romiDrivetrain.setDefaultCommand(m_controldrive);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An Exam(pleCommand will run in autonomous
    //return new Forward(m_romiDrivetrain,10).andThen(new Turn90(m_romiDrivetrain)).andThen(new Forward(m_romiDrivetrain,10)).andThen(new Turn90(m_romiDrivetrain)).andThen(new Forward(m_romiDrivetrain,10).andThen(new Turn90(m_romiDrivetrain)).andThen(new Forward(m_romiDrivetrain, 10)));
    return m_forward;
  }
}
