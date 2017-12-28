import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PACGrid {
	static String[][] S1_Z25;
	static String[][] S101_Z120;
	static String[][] S2_Z26;
	static String[][] A1_P21;
	static String[][] A101_P123;
	static String[][] A2_P22;
	static String[][] AA1_DD1;
	static String[][] AA2_DD2;
	static String[][] GG1_RR23;
	static String[][] DD101_RR124;
	static String[][] GG2_RR24;

	public static void main(String[] args) throws FileNotFoundException {
		File fileout = new File("SeatingChart.txt");
		fileout.delete();
		PrintStream out = new PrintStream(new FileOutputStream(fileout, true));
		System.setOut(out);

		System.out.println("PACGrid v1.1.1");
		System.out.println("Created by Spenser Wong, Nathan Kruse, Michelle Kwon, and Sean Chen");
		System.out.println("110100100,644,1A4");

		A1_P21 = new String[14][];
		A1_P21[0] = new String[11];
		for (int i = 1; i < 8; i++) {
			A1_P21[i] = new String[12];
		}
		for (int i = 8; i < 10; i++) {
			A1_P21[i] = new String[11];
		}
		A1_P21[10] = new String[10];
		A1_P21[11] = new String[9];
		A1_P21[12] = new String[5];
		A1_P21[13] = new String[4];

		A101_P123 = new String[14][];
		for (int i = 0; i < 2; i++) {
			A101_P123[i] = new String[23];
		}
		A101_P123[2] = new String[22];
		A101_P123[3] = new String[23];
		A101_P123[4] = new String[22];
		A101_P123[5] = new String[23];
		A101_P123[6] = new String[21];
		A101_P123[7] = new String[22];
		A101_P123[8] = new String[21];
		A101_P123[9] = new String[20];
		A101_P123[10] = new String[19];
		A101_P123[11] = new String[18];
		A101_P123[12] = new String[17];
		A101_P123[13] = new String[16];

		A2_P22 = new String[14][];
		A2_P22[0] = new String[11];
		for (int i = 1; i < 8; i++) {
			A2_P22[i] = new String[12];
		}
		for (int i = 8; i < 10; i++) {
			A2_P22[i] = new String[11];
		}
		A2_P22[10] = new String[10];
		A2_P22[11] = new String[9];
		A2_P22[12] = new String[5];
		A2_P22[13] = new String[4];

		GG1_RR23 = new String[9][];
		GG1_RR23[0] = new String[12];
		for (int i = 1; i < 4; i++) {
			GG1_RR23[i] = new String[15];
		}
		for (int i = 4; i < GG1_RR23.length; i++) {
			GG1_RR23[i] = new String[12];
		}

		DD101_RR124 = new String[12][];
		for (int i = 0; i < DD101_RR124.length; i++) {
			if (i % 2 == 0) {
				DD101_RR124[i] = new String[24];
			}
			if (i % 2 == 1) {
				DD101_RR124[i] = new String[23];
			}
		}

		GG2_RR24 = new String[9][];
		GG2_RR24[0] = new String[12];
		for (int i = 1; i < 4; i++) {
			GG2_RR24[i] = new String[15];
		}
		for (int i = 4; i < GG2_RR24.length; i++) {
			GG2_RR24[i] = new String[12];
		}

		S1_Z25 = new String[8][];
		for (int i = 0; i < 2; i++) {
			S1_Z25[i] = new String[13];
		}
		for (int i = 2; i < S1_Z25.length; i++) {
			S1_Z25[i] = new String[12];
		}

		S101_Z120 = new String[8][];
		S101_Z120[0] = new String[20];
		S101_Z120[1] = new String[21];
		S101_Z120[2] = new String[22];
		S101_Z120[3] = new String[21];
		S101_Z120[4] = new String[22];
		S101_Z120[5] = new String[14];
		S101_Z120[6] = new String[14];
		S101_Z120[7] = new String[14];

		S2_Z26 = new String[8][];
		for (int i = 0; i < 2; i++) {
			S2_Z26[i] = new String[13];
		}
		for (int i = 2; i < S1_Z25.length; i++) {
			S2_Z26[i] = new String[12];
		}
		AA1_DD1 = new String[3][];
		AA1_DD1[0] = new String[9];
		AA1_DD1[1] = new String[18];
		AA1_DD1[2] = new String[6];

		AA2_DD2 = new String[3][];
		AA2_DD2[0] = new String[13];
		AA2_DD2[1] = new String[18];
		AA2_DD2[2] = new String[6];

		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		String fileNameDefined = "teachers.csv";
		// -File class needed to turn stringName to actual file
		File file = new File(fileNameDefined);

		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String data[] = inputStream.next().split(",");
				teachers.add(new Teacher(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));

			}
			inputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Collections.sort(teachers);
		int idx = 0;
		GridLocation storeA2_P22 = new GridLocation(13, 3);
		GridLocation storeA101_P123 = new GridLocation(0, 22);
		GridLocation storeA1_P21 = new GridLocation(13, 3);
		GridLocation storeS1_Z25 = new GridLocation(7, 11);
		GridLocation storeS101_Z120 = new GridLocation(0, 0);
		GridLocation storeS2_Z26 = new GridLocation(7, 0);
		GridLocation storeAA2_DD2 = new GridLocation(2, 5);
		GridLocation storeGG2_RR24 = new GridLocation(8, 11);
		GridLocation storeDD101_RR124 = new GridLocation(0, 23);
		GridLocation storeAA1_DD1 = new GridLocation(2, 5);
		GridLocation storeGG1_RR23 = new GridLocation(8, 11);

		while (idx < teachers.size()) {
			if (!isFull(A2_P22)) {
				storeA2_P22 = fillBotRight(storeA2_P22, A2_P22, teachers.get(idx));
				if (teachers.get(idx).getNumber() != 0) {
					storeA101_P123 = fillTopRight(storeA101_P123, A101_P123, teachers.get(idx));
				} else {
					idx++;
				}
			} else {
				if (!isFull(A101_P123)) {
					storeA101_P123 = fillTopRight(storeA101_P123, A101_P123, teachers.get(idx));
					if (teachers.get(idx).getNumber() != 0) {
						storeA1_P21 = fillBotRight(storeA1_P21, A1_P21, teachers.get(idx));
					} else {
						idx++;
					}
				} else {
					if (!isFull(A1_P21)) {
						storeA1_P21 = fillBotRight(storeA1_P21, A1_P21, teachers.get(idx));
						if (teachers.get(idx).getNumber() != 0) {
							storeS1_Z25 = fillBotRight(storeS1_Z25, S1_Z25, teachers.get(idx));
						} else {
							idx++;
						}
					} else {
						if (!isFull(S1_Z25)) {
							storeS1_Z25 = fillBotRight(storeS1_Z25, S1_Z25, teachers.get(idx));
							if (teachers.get(idx).getNumber() != 0) {
								storeS101_Z120 = fillTopLeft(storeS101_Z120, S101_Z120, teachers.get(idx));
							} else {
								idx++;
							}
						} else {
							if (!isFull(S101_Z120)) {
								storeS101_Z120 = fillTopLeft(storeS101_Z120, S101_Z120, teachers.get(idx));
								if (teachers.get(idx).getNumber() != 0) {
									storeS2_Z26 = fillBotLeft(storeS2_Z26, S2_Z26, teachers.get(idx));
								} else {
									idx++;
								}
							} else {
								if (!isFull(S2_Z26)) {
									storeS2_Z26 = fillBotLeft(storeS2_Z26, S2_Z26, teachers.get(idx));
									if (teachers.get(idx).getNumber() != 0) {
										storeAA2_DD2 = fillBotRight(storeAA2_DD2, AA2_DD2, teachers.get(idx));
									} else {
										idx++;
									}
								} else {
									if (!isFull(AA2_DD2)) {
										storeAA2_DD2 = fillBotRight(storeAA2_DD2, AA2_DD2, teachers.get(idx));
										if (teachers.get(idx).getNumber() != 0) {
											storeGG2_RR24 = fillBotRight(storeGG2_RR24, GG2_RR24, teachers.get(idx));
										} else {
											idx++;
										}
									} else {
										if (!isFull(GG2_RR24)) {
											storeGG2_RR24 = fillBotRight(storeGG2_RR24, GG2_RR24, teachers.get(idx));
											if (teachers.get(idx).getNumber() != 0) {
												storeDD101_RR124 = fillTopRight(storeDD101_RR124, DD101_RR124,
														teachers.get(idx));
											} else {
												idx++;
											}
										} else {
											if (!isFull(DD101_RR124)) {
												storeDD101_RR124 = fillTopRight(storeDD101_RR124, DD101_RR124,
														teachers.get(idx));
												if (teachers.get(idx).getNumber() != 0) {
													storeAA1_DD1 = fillBotRight(storeAA1_DD1, AA1_DD1,
															teachers.get(idx));
												} else {
													idx++;
												}
											} else {
												if (!isFull(AA1_DD1)) {
													storeAA1_DD1 = fillBotRight(storeAA1_DD1, AA1_DD1,
															teachers.get(idx));
													if (teachers.get(idx).getNumber() != 0) {
														storeGG1_RR23 = fillBotRight(storeGG1_RR23, GG1_RR23,
																teachers.get(idx));
													} else {
														idx++;
													}
												} else {
													if (!isFull(GG1_RR23)) {
														storeGG1_RR23 = fillBotRight(storeGG1_RR23, GG1_RR23,
																teachers.get(idx));
														if (teachers.get(idx).getNumber() != 0) {
															System.out
																	.println("PAC Full : " + teachers.get(idx).getName()
																			+ " has " + teachers.get(idx).getNumber()
																			+ "  students remaining");
															idx++;
														} else {
															idx++;
														}
													} else {
														System.out.println("PAC Full : " + teachers.get(idx).getName()
																+ " has " + teachers.get(idx).getNumber()
																+ "  students remaining");
														idx++;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println();
		printGrid();

	}

	public static void printGrid() {
		for (int j = 0; j < 11; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < 7; j++) {
			System.out.printf("%-10s|", GG1_RR23[0][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 7; j < GG1_RR23[0].length; j++) {
			System.out.printf("%-10s|", GG1_RR23[0][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[0].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[0][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < 7; j++) {
			System.out.printf("%-10s|", GG2_RR24[0][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 7; j < GG2_RR24[0].length; j++) {
			System.out.printf("%-10s|", GG2_RR24[0][j]);
		}
		System.out.println();
		for (int j = 0; j < GG1_RR23[1].length; j++) {
			System.out.printf("%-10s|", GG1_RR23[1][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[1].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[1][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG2_RR24[1].length; j++) {
			System.out.printf("%-10s|", GG2_RR24[1][j]);
		}
		System.out.println();
		for (int j = 0; j < GG1_RR23[2].length; j++) {
			System.out.printf("%-10s|", GG1_RR23[2][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[2].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[2][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG2_RR24[2].length; j++) {
			System.out.printf("%-10s|", GG2_RR24[2][j]);
		}
		System.out.println();
		for (int j = 0; j < GG1_RR23[3].length; j++) {
			System.out.printf("%-10s|", GG1_RR23[3][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[3].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[3][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG2_RR24[3].length; j++) {
			System.out.printf("%-10s|", GG2_RR24[3][j]);
		}
		System.out.println();
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG1_RR23[4].length; j++) {
			System.out.printf("%-10s|", GG1_RR23[4][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[4].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[4][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG2_RR24[4].length; j++) {
			System.out.printf("%-10s|", GG2_RR24[4][j]);
		}
		System.out.println();
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG1_RR23[5].length; j++) {
			System.out.printf("%-10s|", GG1_RR23[5][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[5].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[5][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG2_RR24[5].length; j++) {
			System.out.printf("%-10s|", GG2_RR24[5][j]);
		}
		System.out.println();
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG1_RR23[6].length; j++) {
			System.out.printf("%-10s|", GG1_RR23[6][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[6].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[6][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG2_RR24[6].length; j++) {
			System.out.printf("%-10s|", GG2_RR24[6][j]);
		}
		System.out.println();
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG1_RR23[7].length; j++) {
			System.out.printf("%-10s|", GG1_RR23[7][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[7].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[7][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG2_RR24[7].length; j++) {
			System.out.printf("%-10s|", GG2_RR24[7][j]);
		}
		System.out.println();
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG1_RR23[8].length; j++) {
			System.out.printf("%-10s|", GG1_RR23[8][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[8].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[8][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < GG2_RR24[8].length; j++) {
			System.out.printf("%-10s|", GG2_RR24[8][j]);
		}
		System.out.println();
		for (int j = 0; j < 187; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[9].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[9][j]);
		}
		System.out.println();
		for (int j = 0; j < 187; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[10].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[10][j]);
		}
		System.out.println();
		for (int j = 0; j < 198; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < DD101_RR124[11].length; j++) {
			System.out.printf("%-10s|", DD101_RR124[11][j]);
		}
		System.out.println();
		System.out.println();
		for (int j = 0; j < 55; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < 7; j++) {
			System.out.printf("%-10s|", AA1_DD1[0][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 7; j < AA1_DD1[0].length; j++) {
			System.out.printf("%-10s|", AA1_DD1[0][j]);
		}
		for (int j = 0; j < 187; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < AA2_DD2[0].length; j++) {
			System.out.printf("%-10s|", AA2_DD2[0][j]);
		}
		System.out.println();
		for (int j = 0; j < 44; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < AA1_DD1[1].length; j++) {
			System.out.printf("%-10s|", AA1_DD1[1][j]);
		}
		for (int j = 0; j < 77; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < AA2_DD2[1].length; j++) {
			System.out.printf("%-10s|", AA2_DD2[1][j]);
		}
		System.out.println();
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < AA1_DD1[2].length; j++) {
			System.out.printf("%-10s|", AA1_DD1[2][j]);
		}
		for (int j = 0; j < 363; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < AA2_DD2[2].length; j++) {
			System.out.printf("%-10s|", AA2_DD2[2][j]);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		for (int j = 0; j < S1_Z25[0].length; j++) {
			System.out.printf("%-10s|", S1_Z25[0][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < S101_Z120[0].length; j++) {
			System.out.printf("%-10s|", S101_Z120[0][j]);
		}
		for (int i = 0; i < 55; i++) {
			System.out.print(" ");
		}
		for (int j = 0; j < S2_Z26[0].length; j++) {
			System.out.printf("%-10s|", S2_Z26[0][j]);
		}
		System.out.println();
		for (int j = 0; j < S1_Z25[1].length; j++) {
			System.out.printf("%-10s|", S1_Z25[1][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < S101_Z120[1].length; j++) {
			System.out.printf("%-10s|", S101_Z120[1][j]);
		}
		for (int i = 0; i < 44; i++) {
			System.out.print(" ");
		}
		for (int j = 0; j < S2_Z26[1].length; j++) {
			System.out.printf("%-10s|", S2_Z26[1][j]);
		}
		System.out.println();
		System.out.print("           ");
		for (int j = 0; j < S1_Z25[2].length; j++) {
			System.out.printf("%-10s|", S1_Z25[2][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < S101_Z120[2].length; j++) {
			System.out.printf("%-10s|", S101_Z120[2][j]);
		}
		for (int i = 0; i < 33; i++) {
			System.out.print(" ");
		}
		for (int j = 0; j < S2_Z26[2].length; j++) {
			System.out.printf("%-10s|", S2_Z26[2][j]);
		}
		System.out.println();
		System.out.print("           ");
		for (int j = 0; j < S1_Z25[3].length; j++) {
			System.out.printf("%-10s|", S1_Z25[3][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < S101_Z120[3].length; j++) {
			System.out.printf("%-10s|", S101_Z120[3][j]);
		}
		for (int i = 0; i < 44; i++) {
			System.out.print(" ");
		}
		for (int j = 0; j < S2_Z26[3].length; j++) {
			System.out.printf("%-10s|", S2_Z26[3][j]);
		}
		System.out.println();
		System.out.print("           ");
		for (int j = 0; j < S1_Z25[4].length; j++) {
			System.out.printf("%-10s|", S1_Z25[4][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < S101_Z120[4].length; j++) {
			System.out.printf("%-10s|", S101_Z120[4][j]);
		}
		for (int i = 0; i < 33; i++) {
			System.out.print(" ");
		}
		for (int j = 0; j < S2_Z26[4].length; j++) {
			System.out.printf("%-10s|", S2_Z26[4][j]);
		}
		System.out.println();
		for (int i = 5; i < S1_Z25.length; i++) {
			System.out.print("           ");
			for (int j = 0; j < S1_Z25[i].length; j++) {
				System.out.printf("%-10s|", S1_Z25[i][j]);
			}
			for (int j = 0; j < 22; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 7; j++) {
				System.out.printf("%-10s|", S101_Z120[i][j]);
			}
			for (int n = 0; n < 77; n++) {
				System.out.print(" ");
			}
			for (int j = 7; j < S101_Z120[i].length; j++) {
				System.out.printf("%-10s|", S101_Z120[i][j]);
			}
			for (int l = 0; l < 44; l++) {
				System.out.print(" ");
			}
			for (int j = 0; j < S2_Z26[i].length; j++) {
				System.out.printf("%-10s|", S2_Z26[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[0].length; j++) {
			System.out.printf("%-10s|", A1_P21[0][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[0].length; j++) {
			System.out.printf("%-10s|", A101_P123[0][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[0].length; j++) {
			System.out.printf("%-10s|", A2_P22[0][j]);
		}
		System.out.println();
		for (int j = 0; j < 11; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[1].length; j++) {
			System.out.printf("%-10s|", A1_P21[1][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[1].length; j++) {
			System.out.printf("%-10s|", A101_P123[1][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[1].length; j++) {
			System.out.printf("%-10s|", A2_P22[1][j]);
		}
		System.out.println();
		for (int j = 0; j < 11; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[2].length; j++) {
			System.out.printf("%-10s|", A1_P21[2][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[2].length; j++) {
			System.out.printf("%-10s|", A101_P123[2][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[2].length; j++) {
			System.out.printf("%-10s|", A2_P22[2][j]);
		}
		System.out.println();
		for (int j = 0; j < 11; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[3].length; j++) {
			System.out.printf("%-10s|", A1_P21[3][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[3].length; j++) {
			System.out.printf("%-10s|", A101_P123[3][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[3].length; j++) {
			System.out.printf("%-10s|", A2_P22[3][j]);
		}
		System.out.println();
		for (int j = 0; j < 11; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[4].length; j++) {
			System.out.printf("%-10s|", A1_P21[4][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[4].length; j++) {
			System.out.printf("%-10s|", A101_P123[4][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[4].length; j++) {
			System.out.printf("%-10s|", A2_P22[4][j]);
		}
		System.out.println();
		for (int j = 0; j < 11; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[5].length; j++) {
			System.out.printf("%-10s|", A1_P21[5][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[5].length; j++) {
			System.out.printf("%-10s|", A101_P123[5][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[5].length; j++) {
			System.out.printf("%-10s|", A2_P22[5][j]);
		}
		System.out.println();
		for (int j = 0; j < 11; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[6].length; j++) {
			System.out.printf("%-10s|", A1_P21[6][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[6].length; j++) {
			System.out.printf("%-10s|", A101_P123[6][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[6].length; j++) {
			System.out.printf("%-10s|", A2_P22[6][j]);
		}
		System.out.println();
		for (int j = 0; j < 11; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[7].length; j++) {
			System.out.printf("%-10s|", A1_P21[7][j]);
		}
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[7].length; j++) {
			System.out.printf("%-10s|", A101_P123[7][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[7].length; j++) {
			System.out.printf("%-10s|", A2_P22[7][j]);
		}
		System.out.println();
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[8].length; j++) {
			System.out.printf("%-10s|", A1_P21[8][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[8].length; j++) {
			System.out.printf("%-10s|", A101_P123[8][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[8].length; j++) {
			System.out.printf("%-10s|", A2_P22[8][j]);
		}
		System.out.println();
		for (int j = 0; j < 22; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[9].length; j++) {
			System.out.printf("%-10s|", A1_P21[9][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[9].length; j++) {
			System.out.printf("%-10s|", A101_P123[9][j]);
		}
		for (int j = 0; j < 44; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[9].length; j++) {
			System.out.printf("%-10s|", A2_P22[9][j]);
		}
		System.out.println();
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[10].length; j++) {
			System.out.printf("%-10s|", A1_P21[10][j]);
		}
		for (int j = 0; j < 44; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[10].length; j++) {
			System.out.printf("%-10s|", A101_P123[10][j]);
		}
		for (int j = 0; j < 44; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[10].length; j++) {
			System.out.printf("%-10s|", A2_P22[10][j]);
		}
		System.out.println();
		for (int j = 0; j < 44; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A1_P21[11].length; j++) {
			System.out.printf("%-10s|", A1_P21[11][j]);
		}
		for (int j = 0; j < 44; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[11].length; j++) {
			System.out.printf("%-10s|", A101_P123[11][j]);
		}
		for (int j = 0; j < 55; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A2_P22[11].length; j++) {
			System.out.printf("%-10s|", A2_P22[11][j]);
		}
		System.out.println();
		for (int j = 0; j < 55; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < 3; j++) {
			System.out.printf("%-10s|", A1_P21[12][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 3; j < A1_P21[12].length; j++) {
			System.out.printf("%-10s|", A1_P21[12][j]);
		}
		for (int j = 0; j < 55; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[12].length; j++) {
			System.out.printf("%-10s|", A101_P123[12][j]);
		}
		for (int j = 0; j < 55; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < 2; j++) {
			System.out.printf("%-10s|", A2_P22[12][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 2; j < A2_P22[12].length; j++) {
			System.out.printf("%-10s|", A2_P22[12][j]);
		}
		System.out.println();
		for (int j = 0; j < 66; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < 2; j++) {
			System.out.printf("%-10s|", A1_P21[13][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 2; j < A1_P21[13].length; j++) {
			System.out.printf("%-10s|", A1_P21[13][j]);
		}
		for (int j = 0; j < 55; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < A101_P123[13].length; j++) {
			System.out.printf("%-10s|", A101_P123[13][j]);
		}
		for (int j = 0; j < 66; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j < 2; j++) {
			System.out.printf("%-10s|", A2_P22[13][j]);
		}
		for (int j = 0; j < 33; j++) {
			System.out.print(" ");
		}
		for (int j = 2; j < A2_P22[13].length; j++) {
			System.out.printf("%-10s|", A2_P22[13][j]);
		}
		System.out.println();
	}

	public static GridLocation fillBotRight(GridLocation loc, String[][] in, Teacher t) {
		if (loc.getCol() != in[loc.getRow()].length - 1) {
			if (loc.getRow() - 1 != -1) {
				for (int j = loc.getCol(); j >= 0; j--) {
					if (t.getNumber() > 0) {
						in[loc.getRow()][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(loc.getRow(), j);
					}
				}
				for (int i = loc.getRow() - 1; i >= 0; i--) {
					for (int j = in[i].length - 1; j >= 0; j--) {
						if (t.getNumber() > 0) {
							in[i][j] = t.getName();
							t.setNumber(t.getNumber() - 1);
						} else {
							return new GridLocation(i, j);
						}
					}
				}
			} else {
				for (int j = loc.getCol(); j >= 0; j--) {
					if (t.getNumber() > 0) {
						in[loc.getRow()][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(loc.getRow(), j);
					}
				}
			}
		} else {
			for (int i = loc.getRow(); i >= 0; i--) {
				for (int j = in[i].length - 1; j >= 0; j--) {
					if (t.getNumber() > 0) {
						in[i][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(i, j);
					}
				}
			}
		}

		return new GridLocation(0, 0);
	}

	public static GridLocation fillTopRight(GridLocation loc, String[][] in, Teacher t) {
		if (loc.getCol() != 0) {
			if (loc.getRow() + 1 != in.length) {
				for (int j = loc.getCol(); j >= 0; j--) {
					if (t.getNumber() > 0) {
						in[loc.getRow()][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(loc.getRow(), j);
					}
				}
				for (int i = loc.getRow() + 1; i < in.length; i++) {
					for (int j = in[i].length - 1; j >= 0; j--) {
						if (t.getNumber() > 0) {
							in[i][j] = t.getName();
							t.setNumber(t.getNumber() - 1);
						} else {
							return new GridLocation(i, j);
						}
					}
				}
			} else {
				for (int j = loc.getCol(); j >= 0; j--) {
					if (t.getNumber() > 0) {
						in[loc.getRow()][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(loc.getRow(), j);
					}
				}
			}
		} else {
			for (int i = 0; i < in.length; i++) {
				for (int j = in[i].length - 1; j >= 0; j--) {
					if (t.getNumber() > 0) {
						in[i][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(i, j);
					}
				}
			}
		}
		return new GridLocation(0, 0);
	}

	public static GridLocation fillTopLeft(GridLocation loc, String[][] in, Teacher t) {
		if (loc.getCol() != 0) {
			if (loc.getRow() + 1 != in.length) {
				for (int j = loc.getCol(); j < in[loc.getRow()].length; j++) {
					if (t.getNumber() > 0) {
						in[loc.getRow()][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(loc.getRow(), j);
					}
				}
				for (int i = loc.getRow() + 1; i < in.length; i++) {
					for (int j = 0; j < in[i].length; j++) {
						if (t.getNumber() > 0) {
							in[i][j] = t.getName();
							t.setNumber(t.getNumber() - 1);
						} else {
							return new GridLocation(i, j);
						}
					}
				}
			} else {
				for (int j = loc.getCol(); j < in[loc.getRow()].length; j++) {
					if (t.getNumber() > 0) {
						in[loc.getRow()][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(loc.getRow(), j);
					}
				}
			}
		} else {
			for (int i = 0; i < in.length; i++) {
				for (int j = 0; j < in[i].length; j++) {
					if (t.getNumber() > 0) {
						in[i][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(i, j);
					}
				}
			}
		}

		return new GridLocation(0, 0);
	}

	public static GridLocation fillBotLeft(GridLocation loc, String[][] in, Teacher t) {
		if (loc.getCol() != in[loc.getRow()].length - 1) {
			if (loc.getRow() - 1 != -1) {
				for (int j = loc.getCol(); j < in[loc.getRow()].length; j++) {
					if (t.getNumber() > 0) {
						in[loc.getRow()][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(loc.getRow(), j);
					}
				}
				for (int i = loc.getRow() - 1; i >= 0; i--) {
					for (int j = 0; j < in[i].length; j++) {
						if (t.getNumber() > 0) {
							in[i][j] = t.getName();
							t.setNumber(t.getNumber() - 1);
						} else {
							return new GridLocation(i, j);
						}
					}
				}
			} else {
				for (int j = loc.getCol(); j < in[loc.getRow()].length; j++) {
					if (t.getNumber() > 0) {
						in[loc.getRow()][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(loc.getRow(), j);
					}
				}
			}
		} else {
			for (int i = loc.getRow(); i >= 0; i--) {
				for (int j = 0; j < in[i].length; j++) {
					if (t.getNumber() > 0) {
						in[i][j] = t.getName();
						t.setNumber(t.getNumber() - 1);
					} else {
						return new GridLocation(i, j);
					}
				}
			}
		}

		return new GridLocation(0, 0);
	}

	public static boolean isFull(String[][] in) {
		boolean czech = true;
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[i].length; j++) {
				if (in[i][j] == null) {
					czech = false;
				}
			}
		}
		return czech;
	}
}
