import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.JFileChooser;

public class FileBrowser extends JFrame
{
	public static void main(String [] args)
	{
		FileBrowser mine = new FileBrowser();
	}
	private JTextArea outputArea;
	private JScrollPane scrollPane;
	
	public FileBrowser()
	{
		super("JFileChooser Demo");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout manager = new BorderLayout();
		setLayout(manager);
		
		outputArea = new JTextArea();
		
		scrollPane =  new JScrollPane(outputArea);
		add(scrollPane, BorderLayout.CENTER);
		
		analyzePath();
		
		setVisible(true);
	}
	private File getFileOrDirectory()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		int result = fileChooser.showOpenDialog(this);
		
		if (result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
			
		File fileName = fileChooser.getSelectedFile();
			
		if((fileName == null)||(fileName.getName().equals("")))
		{
			JOptionPane.showMessageDialog(this, "Invalid Name", "Error",
			JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		return fileName;
	}
	public void analyzePath()
	{
		File name = getFileOrDirectory();
		
		if(name.exists())
		{
			outputArea.setText(String.format(
			"%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",name.getName(),
			" exists", (name.isFile() ? "is a file" : "is not a file"), 
			(name.isDirectory() ? "is a directory" : "is not a directory"),
			(name.isAbsolute() ? "is absolute path" : "is relative path"),
			"Last modified: ", name.lastModified(), "Length: ", name.length(), "Path: ",
			name.getPath(), "Absolute path: ", name.getAbsolutePath(),
			"Parent: ", name.getParent()));
			
			if (name.isDirectory())//output directory listing
			{
				String [] directory = name.list();
				outputArea.append("\n\nDirectory contents:\n");
				
				for(String directoryName : directory)
					outputArea.append(directoryName + "\n");
			}//end inner if
		}//end outer if 
		else //is not a file directory, generate error message
		{
			JOptionPane.showMessageDialog(this, name + " does not exist.",
			"ERROR", JOptionPane.ERROR_MESSAGE);
		}//end else
	}





}