package View;

import java.util.Scanner;

public class DepartmentsView {
	
	private Scanner sc= new Scanner(System.in);
	
	public int showmwnu()
	{
		System.out.println("------Department VIew------");
		System.out.println("Enter 1: for add Department");
		System.out.println("Enter 2: for remove Department");
		System.out.println("Enter 3: for update Department");
		System.out.println("Enter 4: for view all Department");
		System.out.println("Enter 5: Exit....");
		
		int i=sc.nextInt();
		return i;
	}
	
	public int getDepartmentId()
{
		System.out.println("Enter the id of department");
		return sc.nextInt();
		}
	
	public String getDepartmentName()
	{
			System.out.println("Enter the name of department");
			return sc.nextLine();
			}
	public String getDepartmentlocation()
	{
			System.out.println("Enter the location of department");
			return sc.nextLine();
			}
	}
