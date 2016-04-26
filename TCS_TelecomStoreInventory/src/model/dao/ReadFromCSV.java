package model.dao;

import java.io.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.pojo.ProductModel;

public class ReadFromCSV {

	/**
	 * @param abc
	 */
	public int createRetailer(String abc) throws IOException {

		//public static boolean readFromCSV(String filename)
		//{
			boolean flag=false;
			int row1=0,row2=0,row3=0,row4=0,row5=0,row6=0, row9=0;
			String ak="", bk="", ck="", dk="", ek="",fk="";

			try {
				BufferedReader reader=new BufferedReader(new FileReader(abc));
				String content="", pmName="", description="", features="", status="",price="",threshold="";
				//int price=0, threshold=0;
				while((content=reader.readLine())!=null){
					String fields[]=content.split(",");
					for(int index=0;index<fields.length;index++)
					{
						if(fields[index].charAt(0)=='\"')
							fields[index]=fields[index].substring(1, fields[index].length()-1);
						switch(index)
						{
						case 0:pmName=fields[index];
						System.out.println(pmName);
						break;
						case 1:description=fields[index];
						System.out.println(description);
						break;
						case 2:features=fields[index];
						System.out.println(features);
						break;
						case 3:price=fields[index];
						System.out.println(price);
						break;
						case 4:threshold=fields[index];
						System.out.println(threshold);
						break;
						case 5:status=fields[index];
						System.out.println(status);
						break;
						}		
					}
					System.out.println(pmName);
					Pattern name = Pattern.compile("[a-zA-Z]*");//name
					Matcher pm = name.matcher(pmName);
					
					System.out.println(description);
					Pattern desc = Pattern.compile("[a-zA-Z]*");//description
					Matcher pd = desc.matcher(description);

					
					System.out.println(features);
					Pattern fea = Pattern.compile("\\w*");//feature
					Matcher pf = fea.matcher(features);

					String p=price;
					System.out.println(p);
					Pattern pri = Pattern.compile("[0-9]+");//price
					Matcher pp = pri.matcher(p);

					String t=threshold;
					System.out.println(t);

					Pattern pt = Pattern.compile("[0-9]+");//threshold
					Matcher pmt = pt.matcher(t);

					Pattern st = Pattern.compile("[a-zA-Z]*");//status
					Matcher ps = st.matcher(status);


					if (pm.matches()) 
					{
						System.out.println("Valid name");
						row1=1;
						System.out.println("row1");
						if (pd.matches())
						{
							System.out.println("Valid description");
							row2=1;
							if (pf.matches())
							{
								System.out.println("Valid features");
								row3=1;
								if (pp.matches()) 
								{
									System.out.println("Valid price");
									row4=1;

									if (pmt.matches()) 
									{
										System.out.println("Valid threshold");
										row5=1;
										if (ps.matches()) 
										{
											System.out.println("Valid status");
											row6=1;
										}
										else
										{
											ek="inValidstatus";
											System.out.println("inValid status");
										}
									}
									else
									{
										dk="inValid threshold";
										System.out.println("INValid threshold");
										row5=0;
									}
								}
								else
								{
									ck="INValid price";
									System.out.println(pp.matches()+"INValid price");
									row4=0;
								}

							}
							else
							{
								bk="INValid features";
								System.out.println("INValid features");
								row3=0;
							}
						}
						else 
						{
							ak="INValid description:";
							System.out.println("INValid description:");
							row2=0;

						}
					}
					else
					{
						fk="INValid name";
						System.out.println("INValid name:");
						row1=0;
					}
					String reason=ak+bk+ck+dk+ek+fk;
					String result="";
					PrintWriter writer=null;
					System.out.println(row1+","+row2+","+row3+","+row4+","+row5+","+row6);
					if(row1==1&&row2==1&&row3==1&&row4==1&&row5==1&&row6==1)
					{
						String pmid=ProductModelDAO.generateNewID();
						int p1=Integer.parseInt(price);
						int p2=Integer.parseInt(threshold);
						ProductModel pmodel=new ProductModel(pmid,pmName, description, features,p1 , p2);
						//ProductModel pmodel=new ProductModel(null,pmName, description, features, Integer.parseInt(price), Integer.parseInt(threshold), status);
						int id=ProductModelDAO.insertProductModelIntoDB(pmodel);
						
						if(id!=0)
							result="successfully added";
						else
							result="duplicate entry";
						boolean flag1=new File("C:\\Users\\592675\\Desktop\\download").mkdir();
						writer=new PrintWriter(new FileWriter("C:\\Users\\592675\\Desktop\\download\\download.csv",true),true);
						System.out.println(result);
						writer.println(result+","+id+","+pmName);

						writer.close();

					}
					else
					{
						result="failed";
						writer=new PrintWriter(new FileWriter("C:\\Users\\592675\\Desktop\\download\\download.csv",true),true);
						writer.println(result+","+" "+","+pmName+","+reason);
					}
				}
				


					reader.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
			}
		}