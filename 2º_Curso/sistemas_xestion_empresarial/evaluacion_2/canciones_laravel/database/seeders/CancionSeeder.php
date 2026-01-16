<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class CancionSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('cancions')->insert([
            'titulo' => 'Feliz Cumpleaños Ferxxo',
            'album' => 'Feliz Cumpleaños Ferxxo Te Pirateamos el Álbum',
            'grupo' => 'Feid',
            'publicacion' => '2022',
            'created_at' => now(),
            'updated_at' => now(),
        ]);

        DB::table('cancions')->insert([
            'titulo' => 'Normal',
            'album' => 'Feliz Cumpleaños Ferxxo Te Pirateamos el Álbum',
            'grupo' => 'Feid',
            'publicacion' => '2022',
            'created_at' => now(),
            'updated_at' => now(),
        ]);

        DB::table('cancions')->insert([
            'titulo' => 'Hey Mor',
            'album' => 'Sixdo',
            'grupo' => 'Feid x Ozuna',
            'publicacion' => '2022',
            'created_at' => now(),
            'updated_at' => now(),
        ]);

        DB::table('cancions')->insert([
            'titulo' => 'Chorrito Pa Las Animas',
            'album' => 'Sixdo',
            'grupo' => 'Feid',
            'publicacion' => '2022',
            'created_at' => now(),
            'updated_at' => now(),
        ]);

        DB::table('cancions')->insert([
            'titulo' => 'Ferxxo 100',
            'album' => 'Ferxxo (Vol 1: M.O.R)',
            'grupo' => 'Feid',
            'publicacion' => '2020',
            'created_at' => now(),
            'updated_at' => now(),
        ]);

        DB::table('cancions')->insert([
            'titulo' => 'Porfa',
            'album' => 'Ferxxo (Vol 1: M.O.R)',
            'grupo' => 'Feid x Justin Quiles',
            'publicacion' => '2020',
            'created_at' => now(),
            'updated_at' => now(),
        ]);
    }
}
