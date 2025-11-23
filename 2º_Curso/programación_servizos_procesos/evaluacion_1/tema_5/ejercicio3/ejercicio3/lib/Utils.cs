using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejercicio3.lib
{
    internal class Utils
    {
        public async Task<string> downloadFileAsync(string fileName, int delayMs)
        {
            await Task.Delay(delayMs);

            return fileName; 
        }
    }
}