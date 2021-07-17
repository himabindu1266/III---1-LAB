import java.awt.*;
import java.applet.*;
/* <applet code="Applet1" width=200 height=300></applet>*/
public class AppletExample extends Applet
{
// Paint method to display the message.
public void paint(Graphics g)
{
g.drawString("Hello World!",40,40);
}
}