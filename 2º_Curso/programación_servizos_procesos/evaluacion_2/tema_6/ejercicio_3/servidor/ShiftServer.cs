using System;
using System.Collections.Generic;
using System.Text;

namespace servidor
{
    internal class ShiftServer
    {
        private string[] Users { get; set; }
        private List<string> WaitQueue { get; set; }

        private void Init()
        {

        }

        private void ReadNames(FileInfo filePath)
        {

            List<string> allUsers = new List<string>();

            try
            {
                using (StreamReader sr = new StreamReader(filePath.FullName))
                {
                    string line;
                    while ((line = sr.ReadLine()) != null)
                    {
                        allUsers.AddRange(line.Split(";"));
                    }

                    Users = allUsers.ToArray();
                }
            }
            catch (IOException e)
            {
                Console.WriteLine($"ERROR: {e.Message}");
            }
        }

        private int ReadPin(FileInfo filePath)
        {
            try
            {
                using (StreamReader sr = new StreamReader(filePath.FullName))
                {
                    string line = sr.ReadLine();
                    int[] numeros = new int[4];
                }
            }
            catch (IOException e)
            {
                return -1;
            }
        }
    }
}
